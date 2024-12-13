import java.util.*;
import java.util.concurrent.*;

/*
 * Вариант 5
 */

public class WarehouseTransfer {
    private static final int MAX_WEIGHT = 150; // Максимальный вес для одной поездки

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Список товаров с их весами
        List<Item> items = Arrays.asList(
            new Item(50), new Item(40), new Item(60),
            new Item(30), new Item(70), new Item(80),
            new Item(20), new Item(40), new Item(50),
            new Item(10), new Item(90), new Item(30)
        );

        // Создаём пул потоков с 3 грузчиками
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Для каждого грузчика создаём CompletableFuture
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        // Разбиваем список товаров на несколько частей для каждого грузчика
        List<List<Item>> partitions = partitionItems(items, 3);

        for (int i = 0; i < 3; i++) {
            int loaderId = i;
            List<Item> loaderItems = partitions.get(i);

            // Асинхронное выполнение задачи для каждого грузчика
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try {
                    processItemsForLoader(loaderId, loaderItems);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, executor);

            futures.add(future);
        }

        // Ожидаем завершения всех задач
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        // Завершаем работу пула потоков
        executor.shutdown();
    }

    // Метод для обработки товаров для одного грузчика
    private static void processItemsForLoader(int loaderId, List<Item> items) throws InterruptedException {
        int currentWeight = 0;
        List<Item> toCarry = new ArrayList<>();

        for (Item item : items) {
            if (currentWeight + item.getWeight() > MAX_WEIGHT) {
                // Если грузчик набрал максимальный вес, он переносит товары
                deliverItems(loaderId, toCarry);

                // Очищаем список и начинаем с нового набора товаров
                currentWeight = 0;
                toCarry.clear();
            }
            // Добавляем товар в список для переноса
            toCarry.add(item);
            currentWeight += item.getWeight();
        }

        // Переносим оставшиеся товары, если есть
        if (!toCarry.isEmpty()) {
            deliverItems(loaderId, toCarry);
        }
    }

    // Метод для симуляции переноса товаров
    private static void deliverItems(int loaderId, List<Item> items) throws InterruptedException {
        System.out.println("loader " + loaderId + " transfers: " + items);
        System.out.println("loader " + loaderId + " completed the transfer.");
    }

    // Разбиение списка товаров на части для каждого грузчика
    private static List<List<Item>> partitionItems(List<Item> items, int numPartitions) {
        List<List<Item>> partitions = new ArrayList<>();
        int partitionSize = (int) Math.ceil((double) items.size() / numPartitions);
        
        for (int i = 0; i < numPartitions; i++) {
            int fromIndex = i * partitionSize;
            int toIndex = Math.min((i + 1) * partitionSize, items.size());
            partitions.add(new ArrayList<>(items.subList(fromIndex, toIndex)));
        }

        return partitions;
    }
}

// Класс для товара с его весом
class Item {
    private int weight;

    public Item(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Item{" + "weight=" + weight + '}';
    }
}

/*
 * Смысл и преимущества использования CompletableFuture
 * 
 * Асинхронное выполнение:
 * 
 * Основная цель CompletableFuture — это возможность асинхронно выполнять задачи, не блокируя основной поток выполнения программы.
 * В нашем примере мы создаем три задачи (перенос товаров) и выполняем их параллельно.
 * Каждый грузчик выполняет свою задачу независимо, что позволяет оптимально использовать доступные ресурсы (например, многопроцессорные системы) 
 * и улучшить производительность программы.
 * В отличие от обычных Future, которые можно использовать для синхронного получения результатов (с блокировкой потока), 
 * CompletableFuture позволяет легко работать с асинхронными операциями, не блокируя поток до получения результата.
 * 
 * Управление зависимостями между задачами:
 * 
 * С помощью CompletableFuture можно легко установить цепочку зависимостей между задачами. 
 * Например, вы можете задать, что одна задача должна начаться только после того, как завершится другая.
 * В нашем примере задачи (перенос товаров) для каждого грузчика выполняются независимо друг от друга. 
 * Однако если бы возникла ситуация, когда задача одного грузчика зависела бы от другого, 
 * CompletableFuture легко решает эту задачу с помощью методов thenCompose(), thenCombine(), whenComplete() и т. д.
 * 
 * Удобство с асинхронными результатами:
 * 
 * CompletableFuture позволяет удобно работать с результатами асинхронных вычислений.
 * В примере задачи грузчиков результат выполнения каждой задачи (перенос товаров) может быть обработан, 
 * как только задача будет завершена, без блокировки основного потока.
 * В реальных приложениях (например, с API или сетевыми запросами) это особенно важно, 
 * так как можно не блокировать весь процесс, а лишь работать с результатами по мере их готовности.
 * 
 * Обработка ошибок:
 * 
 * В случае с CompletableFuture ошибки можно обрабатывать через методы exceptionally() или handle(). 
 * Это позволяет красиво и надежно управлять исключениями в асинхронных операциях. 
 * Вы можете, например, указать, что делать, если один из грузчиков не смог выполнить задачу (например, из-за ошибки, например, нехватки ресурсов).
 * В нашем примере мы не используем исключения, но в более сложных приложениях эта особенность может быть полезной.
 * 
 * Композиция задач:
 * 
 * CompletableFuture позволяет легко составлять сложные цепочки асинхронных операций. 
 * Например, можно выполнить несколько операций параллельно и затем объединить их результаты, 
 * что значительно упрощает код по сравнению с использованием обычных потоков.
 * В случае с несколькими грузчиками мы могли бы использовать thenCombine() для того, 
 * чтобы после выполнения всех задач объединить результаты (например, подсчитать количество перенесенных товаров или общий вес).
 * 
 * Управление временем и тайм-аутами:
 * 
 * CompletableFuture поддерживает операции, связанные с временем, например, completeOnTimeout(), что позволяет задать тайм-аут для выполнения задачи.
 * Это может быть полезно в реальных приложениях для предотвращения зависаний.
 * Например, если одна из задач по переносу товаров занимает слишком много времени, можно принудительно завершить ее по тайм-ауту.
 * 
 * Не блокирует основной поток:
 * 
 * Одним из важных аспектов CompletableFuture является то, что асинхронные задачи не блокируют основной поток. 
 * Это полезно, если нужно продолжать выполнение других операций, пока одна из задач выполняется в фоновом режиме.
 * В нашем случае это дает возможность продолжать другие операции на основном потоке, например,
 * обрабатывать данные или обновлять интерфейс, пока грузчики переносят товары.
 */