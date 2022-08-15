public class Frog {
    
    // variables

    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet = true;
    private static String species = "Rare Pepe";
    public static int DEFAULT_AGE = 5; 
    public static double DEFAULT_TONGUE_SPEED = 5;

    // constructors

    public Frog(String name) {
        this(name, DEFAULT_AGE, DEFAULT_TONGUE_SPEED);
    }

    public Frog(String name, double ageInYears) {
        this(name, ((int) ageInYears * 12), DEFAULT_TONGUE_SPEED);
    }

    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
    }

    // methods

    public void grow(int numMonths) {
        int addOneThreshold = 12;
        int totalMonths = numMonths + age;
        if (age < addOneThreshold) {
            int increase = addOneThreshold - age;
            tongueSpeed += increase;
            numMonths -= increase;
        }

        age = totalMonths;

        if (age >= 30) {
            int decrease = age - 30;
            tongueSpeed = tongueSpeed - decrease < 5 ? 5 : tongueSpeed - decrease;
        }
        
        // Update isFroglet
        isFroglet = (age > 1) && (age < 7);
    }

    public void grow() {
        grow(1);
    }

    public void eat(Fly fly) {
        if (fly.isDead()) {
            return;
        }
        boolean isCaught = tongueSpeed > fly.getSpeed();
        if (isCaught && ((fly.getMass() / age) >= 0.5)) {
            grow();
            fly.setMass(0);
        }
        else {
            fly.grow(1);
        }
    }

    public String toString() {
        if (isFroglet) {
            return String.format("My name is %s and I'm a rare froglet! I'm %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
        }
        else {
            return String.format("My name is %s and I'm a rare frog. I'm %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
        }
    }

    public static String getSpecies() {
        return species;
    }

    public static void setSpecies(String newSpecies) {
        species = newSpecies;
    }

    
}
