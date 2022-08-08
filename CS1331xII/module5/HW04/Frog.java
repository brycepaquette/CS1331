import org.w3c.dom.NameList;

public class Frog {
    
    // variables

    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
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
        for (int i = 0; i < numMonths; i++) {
            // Then it ages the Frog by the given number of months and increases tongueSpeed by 1 for every month the Frog grows until it becomes 12 months old.
            age += 1;
            if (age < 12) {
                tongueSpeed += 1;
            }
            // If the Frog is 30 months old or more, then decrease tongueSpeed by 1 for every month that it ages beyond 30 months.You must not decrease tongueSpeed to less than 5.
            else if ((age >= 30) && (tongueSpeed > 5)) {
                tongueSpeed -= 1;
            }
            else {
                continue;
            }
        }
        // Update isFroglet
        isFroglet = (age > 1) && (age < 7);
    }

    public void grow() {
        grow(1);
    }
}
