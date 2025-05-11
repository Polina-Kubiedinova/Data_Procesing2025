public abstract class Appliance {
    public abstract void turnOn();
    public static void main(String[] args) {
        Appliance washer = new WashingMachine();
        Appliance micro = new Microwave();

        washer.turnOn();
        micro.turnOn();
    }
}