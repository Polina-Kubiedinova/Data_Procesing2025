public abstract class Shape {
    public abstract double calculateArea();
    public static void main(String[] args) {
        Shape triangle = new Triangle(5.0, 4.0);
        Shape square = new Square(3.0);

        System.out.println("Площа трикутника: " + triangle.calculateArea());
        System.out.println("Площа квадрата: " + square.calculateArea());
    }
}
