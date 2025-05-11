public class Employee {
    protected String name;
    protected String position;

    // Конструктор
    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    // Метод для виводу інформації
    public void displayInfo() {
        System.out.println("Ім'я: " + name);
        System.out.println("Посада: " + position);
    }
}
