public class Motorcycle extends Vehicle{
        private int engineCapacity; // в куб. см

        // Конструктор
        public Motorcycle(String make, String model, int engineCapacity) {
            super(make, model); // виклик конструктора Vehicle
            this.engineCapacity = engineCapacity;
        }

        // Перевизначений метод displayInfo
        @Override
        public void displayInfo() {
            super.displayInfo(); // викликаємо displayInfo() з Vehicle
            System.out.println("Об’єм двигуна: " + engineCapacity + " см³");
        }
    public static void main(String[] args) {
        Motorcycle moto = new Motorcycle("Yamaha", "MT-07", 689);
        moto.displayInfo();
    }
}
