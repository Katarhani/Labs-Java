import java.io.*;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class DataManager {
    private final List<Object> processors = new ArrayList<>();
    private List<String> data = new ArrayList<>();

    // Регистрирует объект обработчика данных
    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    // Загружает данные из файла
    public void loadData(String source) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            data = reader.lines().collect(Collectors.toList());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Запускает многопоточную обработку данных с использованием Stream API
    public void processData() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);  // Используем пул из 4 потоков
        List<Callable<Void>> tasks = new ArrayList<>();

        // Обрабатываем методы с аннотацией @DataProcessor
        for (Object processor : processors) {
            Method[] methods = processor.getClass().getMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    tasks.add(() -> {
                        method.invoke(processor, data);  // Применяем метод к данным
                        return null;
                    });
                }
            }
        }

        // Выполняем все задачи параллельно
        try {
            executorService.invokeAll(tasks);
            executorService.shutdown();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Сохраняет обработанные данные в новый файл
    public void saveData(String destination) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
