public class Manager extends Employee {
    private int teamSize;

    // Конструктор
    public Manager(String name, String position, int teamSize) {
        super(name, position); // Викликаємо конструктор базового класу
        this.teamSize = teamSize;
    }

    // Перевизначений метод displayInfo()
    @Override
    public void displayInfo() {
        super.displayInfo(); // Виводимо базову інформацію
        System.out.println("Розмір команди: " + teamSize + " осіб");
    }
    public static void main(String[] args) {
        Manager manager = new Manager("Олена Коваль", "Керівник проєкту", 8);
        manager.displayInfo();
    }
}
