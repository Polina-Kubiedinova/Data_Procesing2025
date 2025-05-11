public class Triangle extends Shape {
    private double base;
    private double height;

    // Конструктор
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    // Реалізація методу calculateArea()
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}
