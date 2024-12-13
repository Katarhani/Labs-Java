import java.util.HashMap;
import java.util.Map;

public class SalesTreckerTest {
    public static void main(String[] args) {
        SalesTracker salesTracker = new SalesTracker();

        salesTracker.addSale("prod1", 10);
        salesTracker.addSale("prod2", 5);
        salesTracker.addSale("prod3", 7);
        salesTracker.addSale("prod1", 3);

        salesTracker.displaySales();
        System.out.println("Total: " + salesTracker.calculateTotalSales());
        System.out.println("Most pop. prod.: " + salesTracker.findMostPopularItem());
    }
}

class SalesTracker {
    private HashMap<String, Integer> sales;

    public SalesTracker() {
        this.sales = new HashMap<>();
    }
    //функция добавления продаж
    //конфеты, если есть параметры какие-то, то сначала будет по умолчанию нал. елси нал то добав 0 с помощью дефолта
    public void addSale(String item, int quantity) {
        sales.put(item, sales.getOrDefault(item, 0) + quantity);
    }

    public void displaySales() {
        if (sales.isEmpty()) {
            System.out.println("List empty");
        } else {
            System.out.println("List sales:");

            for (Map.Entry<String, Integer> entry : sales.entrySet()) {
                System.out.println("prod: " + entry.getKey() + ", count: " + entry.getValue());
            }
        }
    }
    
    // Метод для подсчета общей суммы продаж (зависит от цены товара)
    public int calculateTotalSales() {
        int total = 0;
        
        // Проходим по всем товарам в salesMap
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            total += entry.getValue();
        }
        
        return total;
    }
    
    // Метод для нахождения наиболее популярного товара
    public String findMostPopularItem() {
        if (sales.isEmpty()) {
            return "List empty";
        }
        
        String mostPopularItem = null;
        int maxSales = 0;
        
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > maxSales) {
                maxSales = entry.getValue();
                mostPopularItem = entry.getKey();
            }
        }
        
        return mostPopularItem;
    }
}
