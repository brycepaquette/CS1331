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

}
