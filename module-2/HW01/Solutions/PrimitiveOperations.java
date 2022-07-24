package Solutions;
public class PrimitiveOperations {
    public static void main(String[] args) {
        // declare and initialize two variables, an integer type (byte, short, int, or long) and a floating point value (float or double)
        int valOne = 100;
        float valTwo = 200.0F;
        // Print each of these values out on their own line using System.out.println()
        System.out.println(valOne);
        System.out.println(valTwo);
        // Multiply these variables together, and assign the outcome to a new variable, ensuring that no data is lost
        float mplyVals = valOne * valTwo;
        // Print out this new value
        System.out.println(mplyVals);
        // Use casting to convert the integer from the first step to a floating point value and store that in another new variable
        float valOneFloat = (float) valOne;
        // Print out the value
        System.out.println(valOneFloat);
        // Use casting to convert the floating point value from the first step to an integer type and store that in a new variable
        int valTwoInt = (int) valTwo;
        // Print out the value
        System.out.println(valTwoInt);
        // Declare a char variable, and assign an uppercase letter to it
        char letterOne = 'A';
        // Print out the value
        System.out.println(letterOne);
        // Using a numerical operation, change the letter to the same letter, but in lowercase (review a table of ASCII values)
        letterOne = (char) (letterOne + 32);
        // Print out the new char value (Hint: you’ll likely have to use casting to get this to work)
        System.out.println(letterOne);
    }
}
