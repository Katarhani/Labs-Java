import java.util.HashMap;
import java.util.Scanner;


class Product {
    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + " (Цена: " + price + ", Количество: " + quantity + ")";
    }
}

public class Warehouse {
    // HashMap для хранения продуктов
    HashMap<String, Product> products = new HashMap<>();

    // Метод для добавления продукта
    public void addProduct(String barcode, String name, double price, int quantity) {
        products.put(barcode, new Product(name, price, quantity));
    }

    // Метод для поиска продукта
    public Product getProduct(String barcode) {
        return products.get(barcode);
    }

    // Метод для удаления продукта
    public void removeProduct(String barcode) {
        products.remove(barcode);
    }

    // Метод для вывода всех продуктов
    public void showAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Склад пуст");
        } else {
            for (String barcode : products.keySet()) {
                System.out.println("Штрихкод: " + barcode + ", " + products.get(barcode));
            }
        }
    }

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Scanner scanner = new Scanner(System.in);

        warehouse.addProduct("123", "Яблоко", 0.50, 100);
        warehouse.addProduct("456", "Банан", 0.30, 150);
        warehouse.addProduct("789", "Апельсин", 0.60, 80);

        System.out.println("Введите штрихкод для посика продукта:");
        String searchBarcode = scanner.nextLine();
        Product foundProduct = warehouse.getProduct(searchBarcode);
        if (foundProduct != null) {
            System.out.println("Найден: " + foundProduct);
        } else {
            System.out.println("Продукт не найден");
        }
        
        System.out.println("Введите штрихкод для удаления продукта:");
        String removeBarcode = scanner.nextLine();
        warehouse.removeProduct(removeBarcode);

        warehouse.showAllProducts();
    }
}
