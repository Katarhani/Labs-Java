import java.util.List;
import java.util.stream.Collectors;

public class DataAggregator {
    @DataProcessor
    public void aggregateData(List<String> data) {
        // Пример агрегации: соединение всех строк в одну
        String aggregated = data.stream().collect(Collectors.joining(" "));
        data.clear();
        data.add(aggregated);
    }
}
