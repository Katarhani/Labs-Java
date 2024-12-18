public class Main {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();

        // Регистрируем обработчики данных
        dataManager.registerDataProcessor(new DataFilter());
        dataManager.registerDataProcessor(new DataTransformer());
        dataManager.registerDataProcessor(new DataAggregator());

        // Загружаем данные из файла
        dataManager.loadData("D:\\Apps\\Работы по вузу\\ИТ 2  семак\\Лабы\\Лаба 8\\input.txt");

        // Обрабатываем данные с использованием многопоточности
        dataManager.processData();

        // Сохраняем обработанные данные в новый файл
        dataManager.saveData("D:\\Apps\\Работы по вузу\\ИТ 2  семак\\Лабы\\Лаба 8\\output.txt");
    }
}
