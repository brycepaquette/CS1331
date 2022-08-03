public class initCar {
    public static void main(String[] args) {
        Car bmw = new Car(40, 30);
        System.out.println("initGas: " + bmw.getFuel());
        bmw.drive(40, 40);
        System.out.println("gas left: " + bmw.getFuel());
        bmw.refuel(100 - bmw.getFuel());
        System.out.println("refueled: " + bmw.getFuel());
        System.out.println(Car.produceRandomFact());
    }
}
