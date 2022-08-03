import java.util.Random;

public class Die {
    
    // # of Sides
    public static final int SIDES = 6;
    // Face value
    private int faceValue;
    // Random object
    private Random rand;


    // Constructor
    public Die() {
        faceValue = 1;
        rand = new Random();
    }


    // Methods

    public int roll() {
        faceValue = rand.nextInt(SIDES) + 1;
        return faceValue;
    }

    // Getter Methods

    public int getFaceValue() {
        return faceValue;
    }

    public String toString() {
        return "Die with face value: " + faceValue;
    }


    //main method
    public static void main(String[] args) {
        Die die1 = new Die();
        System.out.println(die1.toString());
        System.out.println(die1.roll());
        System.out.println(die1.roll());
    } 
}
