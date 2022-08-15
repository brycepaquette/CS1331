public class Fly {

    // variables

    private double mass;
    private double speed;
    public static double DEFAULT_SPEED = 10;
    public static double DEFAULT_MASS = 5;

    // constructor chaining

    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    public Fly(double mass) {
        this(mass, DEFAULT_SPEED);
    }

    public Fly() {
        this(DEFAULT_MASS);
    }

    // Getter Methods

    public double getMass() {
        return mass;
    }

    public double getSpeed() {
        return speed;
    }

    // Setter Methods

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String toString() {
        if (mass == 0) {
            return String.format("I'm dead, but I used to be a fly with a speed of %.2f", speed);
        }
        else {
            return String.format("I'm a speedy fly with %.2f speed and %.2f mass.", speed, mass);
        }
    }

    public void grow(int size) {
        // Loop through each size increase by 1
        int threshold = 20;
        // If mass is less than 20: increases speed by 1 for every mass the Fly grows until it reaches 20 mass.
        if (mass < threshold) {
            double increase = threshold - mass;
            speed += increase;
            mass += increase;
            size -= increase;
        }
        speed -= size * 0.5;
        mass += size;
    }

    public boolean isDead() {
        return mass == 0; 
    }
}