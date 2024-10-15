// Абстрактный базовый класс 
abstract class Bike {
    // Поля (инкапсуляция)
    protected String model;
    protected int gearCount;
    protected double weight;

    private static int objectCounter = 0;

    // Конструктор по умолчанию
    public Bike() {
        objectCounter++;
    }

    // Конструктор с параметрами
    public Bike(String model, int gearCount, double weight) {
        this.model = model;
        this.gearCount = gearCount;
        this.weight = weight;
        objectCounter++;
    }

    // Абстрактный метод (абстракция)
    public abstract void ride();

    // Обычный метод
    public void brake() {
        System.out.println(model + " Тормоза в комплекте.");
    }

    // Геттеры и сеттеры (инкапсуляция)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getGearCount() {
        return gearCount;
    }

    public void setGearCount(int gearCount) {
        this.gearCount = gearCount;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public static int getObjectCounter() {
        return objectCounter;
    }
}

// Класс MountainBike
class MountainBike extends Bike {
    private String suspensionType;

    // Конструктор по умолчанию
    public MountainBike() {
        super();
        this.suspensionType = "Standard";
    }

    // Конструктор с параметрами (перегрузка конструктора)
    public MountainBike(String model, int gearCount, double weight, String suspensionType) {
        super(model, gearCount, weight);
        this.suspensionType = suspensionType;
    }

    // Переопределение абстрактного 
    @Override
    public void ride() {
        System.out.println(model + " Горный велосипед с подвеской " + suspensionType + ".");
    }

    public String getSuspensionType() {
        return suspensionType;
    }

    public void setSuspensionType(String suspensionType) {
        this.suspensionType = suspensionType;
    }
}

// Класс ChildBike 
class ChildBike extends Bike {
    private boolean hasTrainingWheels;

    // Конструктор по умолчанию
    public ChildBike() {
        super();
        this.hasTrainingWheels = true;
    }

    // Конструктор с параметрами
    public ChildBike(String model, int gearCount, double weight, boolean hasTrainingWheels) {
        super(model, gearCount, weight);
        this.hasTrainingWheels = hasTrainingWheels;
    }

    // Переопределение метода ride
    @Override
    public void ride() {
        String trainingWheelsStatus = hasTrainingWheels ? "с дополнительными колесами" : "без дополнительных колес";
        System.out.println(model + " Детский велосипед " + trainingWheelsStatus + ".");
    }

    public boolean hasTrainingWheels() {
        return hasTrainingWheels;
    }

    public void setTrainingWheels(boolean hasTrainingWheels) {
        this.hasTrainingWheels = hasTrainingWheels;
    }
}

// Класс BMX
class BMX extends Bike {
    protected boolean hasPegs;

    // Конструктор по умолчанию
    public BMX() {
        super();
        this.hasPegs = false;
    }

    // Конструктор с параметрами
    public BMX(String model, int gearCount, double weight, boolean hasPegs) {
        super(model, gearCount, weight);
        this.hasPegs = hasPegs;
    }

    // Переопределение метода ride
    @Override
    public void ride() {
        String pegsStatus = hasPegs ? "с пегами" : "без пегов";
        System.out.println(model + " BMX " + pegsStatus + ".");
    }

    public boolean hasPegs() {
        return hasPegs;
    }

    public void setPegs(boolean hasPegs) {
        this.hasPegs = hasPegs;
    }
}

class Pegs extends BMX{
    private String color;


    public Pegs (){
        super();
        this.color = "Black";
    }

    public Pegs (String model, int gearCount, double weight, boolean hasPegs, String color){
        super(model, gearCount, weight, hasPegs);
        this.color = color;
    }
    

    @Override
    public void ride(){
        String pegsStatus = hasPegs ? "с пегами" : "без пегов";
        System.out.println(model + " BMX " + pegsStatus + " цвета " + color + ".");

    }

    public String getColor(){
        return color;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    

}

// Класс для демонстрации работы

public class Main {
    public static void main(String[] args) {
        // Создание объектов
        MountainBike mountainBike = new MountainBike("RockRider", 21, 14.5, "Full Suspension");
        ChildBike childBike = new ChildBike("KidsFun", 1, 6.2, true);
        BMX bmx = new BMX("BMX Pro", 1, 10.8, true);
        Pegs pegs = new Pegs ("BMX Ultra", 5, 15, true, "Красный");
        // Вызов методов ride и brake
        mountainBike.ride();
        mountainBike.brake();

        childBike.ride();
        childBike.brake();

        bmx.ride();
        bmx.brake();

        pegs.ride();
        pegs.brake();

        System.out.println("Количество созданных велосипедов: " + Bike.getObjectCounter());
    }

    
}

