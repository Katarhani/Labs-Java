import java.util.List;

public class DataFilter {
    @DataProcessor
    public void filterData(List<String> data) {
        // Пример фильтрации: убираем строки, содержащие "error"
        data.removeIf(line -> line.contains("la"));
    }
}
