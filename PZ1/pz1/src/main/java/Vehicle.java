public class Vehicle {
    protected String make;
    protected String model;

    // Конструктор
    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    // Метод для виводу інформації
    public void displayInfo() {
        System.out.println("Марка: " + make);
        System.out.println("Модель: " + model);
    }
}
