public class Car {
   
   
//Instance Variables (Instance variables - each instance of the class will have variable values unique to the instance)

    private double fuel = 100;
    private int x;
    private int y;


//Static variables

    private static int population;


// Static constants

    public static int DEFAULT_X = 0;
    public static int DEFAULT_Y = 0;
    public static double DEFAULT_FUEL = 100.0;
    public static final double DIST_FUEL_CONSUMPTION_FACTOR = .01;
    private static final String[] FACTS = {
        "The two main groups of vehicles are cars and trucks.",
        "There are more than 1 million cars in the world.",
        "Big trucks usually run on diesel fuel.",
        "Vans are not considered to be cars."
    };
    

// Test method
    public static void main(String[] args) {
        Car bmw = new Car(40,50, 100.0);
        Car cadillac = new Car(40, 30, 100.0);
        Car defaultCar = new Car(100.0);
        Car defaultCar2 = new Car();
        // System.out.println("DONE");
    }


// Overloading Constructors

    // public Car(int initX, int initY, double initFuel) {
    //     fuel = initFuel;
    //     x = initX;
    //     y = initY;
    //     population++;
    // }

    // public Car(double initFuel) {
    //     fuel = initFuel;
    //     x = DEFAULT_X;
    //     y = DEFAULT_Y;
    //     population++;
    // }


// Constructor Chaining and using this()

    // public Car() {
    //     this(DEFAULT_FUEL);
    // }

    // public Car(double initFuel) {
    //     this(DEFAULT_X, DEFAULT_Y, initFuel);
    // }

    // public Car(int initX, int initY, double initFuel) {
    //     x = initX;
    //     y = initY;
    //     fuel = initFuel;
    // }


// Using "this" as a reference

    public Car() {
        this(DEFAULT_FUEL);
    }

    public Car(double fuel) {
        this(DEFAULT_X, DEFAULT_Y, fuel);
    }

    public Car(int x, int y, double fuel) {
        this.x = x;
        this.y = y;
        this.fuel = fuel;
    }
    
    
// Methods
    
    public void refuel(double amount) {
        System.out.println("Refueling...");
        fuel += amount;
    }
    
    public void drive(int newX, int newY) {
        double distance = calculateDistance(x, y, newX, newY);
        if (distance > 0) {
            x = newX;
            y = newY;
            fuel = fuel * DIST_FUEL_CONSUMPTION_FACTOR * distance;
        }
        else {
            System.out.println("Idling...");
        }
    }


// Getter Methods

    public double getFuel() {
        return fuel;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


// Setter Methods

    public void resetFuel() {
        fuel = 100;
    }

    public void setX(int newX) {
        if (isLegal(newX)) {
            x = newX;
        }
    }

    public void setY(int newY) {
        if (isLegal(newY)) {
            y = newY;
        }
    }


// Helper Methods

    private static double calculateDistance(double x1, double x2, double y1, double y2) {
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }

    private static boolean isLegal(int newCoordinate) {
        return (newCoordinate >= 0 ? true : false);
    }


// Static Methods

    public static String produceRandomFact() {
        int index = (int) (Math.random() * ((FACTS.length - 1) + 1));
        return FACTS[index];
    }

    public static int getPopulation() {
        return population;
    }
}