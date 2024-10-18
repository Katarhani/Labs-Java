import java.util.HashMap;
import java.util.Scanner;

// Класс для продукта с названием, ценой и количеством
class Product {
    String name;    // Название продукта
    double price;   // Цена продукта
    int quantity;   // Количество на складе

    // Конструктор
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Переопределяем метод toString для удобного вывода
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
            System.out.println("Склад пуст.");
        } else {
            for (String barcode : products.keySet()) {
                System.out.println("Штрихкод: " + barcode + ", " + products.get(barcode));
            }
        }
    }

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Scanner scanner = new Scanner(System.in);

        // Добавление предустановленных продуктов
        warehouse.addProduct("123", "Яблоко", 0.50, 100);
        warehouse.addProduct("456", "Банан", 0.30, 150);
        warehouse.addProduct("789", "Апельсин", 0.60, 80);

        // Поиск продукта
        System.out.println("Введите штрихкод для поиска продукта:");
        String searchBarcode = scanner.nextLine();
        Product foundProduct = warehouse.getProduct(searchBarcode);
        if (foundProduct != null) {
            System.out.println("Найден: " + foundProduct);
        } else {
            System.out.println("Продукт не найден.");
        }

        // Удаление продукта
        System.out.println("Введите штрихкод для удаления продукта:");
        String removeBarcode = scanner.nextLine();
        warehouse.removeProduct(removeBarcode);

        // Показ всех продуктов
        warehouse.showAllProducts();

        // Добавление продукта вручную
        System.out.println("Введите штрихкод для добавления продукта:");
        String newBarcode = scanner.nextLine();
        System.out.println("Введите название продукта:");
        String name = scanner.nextLine();
        System.out.println("Введите цену продукта:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Введите количество продукта:");
        int quantity = Integer.parseInt(scanner.nextLine());

        warehouse.addProduct(newBarcode, name, price, quantity);
        System.out.println("Продукт успешно добавлен!");

        // Показ всех продуктов после добавления
        warehouse.showAllProducts();

        scanner.close();
    }
}
