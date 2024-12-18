import java.util.List;

public class DataTransformer {
    @DataProcessor
    public void transformData(List<String> data) {
        // Преобразуем все строки в верхний регистр
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i).toUpperCase());
        }
    }
}
