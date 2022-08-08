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
            return String.format("I'm a speedy fly with %.2f speed, and %.2f mass.", speed, mass);
        }
    }

    public void grow(int size) {
        // Loop through each size increase by 1
        for (int i = 0; i < size; i++) {
            // Increase mass by 1
            mass += 1;
            // If mass is less than 20: increases speed by 1 for every mass the Fly grows until it reaches 20 mass.
            if (mass < 20) {
                speed += 1;
            }
            // If the mass is 20 or more: decreases speed by 0.5 for each mass unit added over 20.
            else {
                speed -= 0.5;
            }
        }
    }

    public boolean isDead() {
        return mass == 0; 
    }
}