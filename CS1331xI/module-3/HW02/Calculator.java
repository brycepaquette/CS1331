import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // Instantiate Scanner Object
        Scanner sc = new Scanner(System.in);

        // My added code: Array of operations, error string
        String[] opArr = {"add", "subtract", "multiply", "divide", "alphabetize"};
        String errorMsg = "Invalid input entered. Terminating...";
        int intOne = 0;
        int intTwo;
        double dblOne = 0;
        double dblTwo;
        int resultInt;
        double resultDbl;

        
        // Prompt the user to enter an operation. This operation must be processed as case-insensitive
        System.out.println("List of Operations: " + String.join(" ", opArr));
        
        System.out.println("Enter an operation: ");
        String op = sc.nextLine().toLowerCase();
        switch(op) {
            case "add":
                // If the user is performing an add/subtract operation, prompt the user to enter two integers.
                System.out.println("Enter two integers: ");

                if (sc.hasNextInt())
                    intOne = sc.nextInt();
                if (sc.hasNextInt()) {
                    intTwo = sc.nextInt();
                    resultInt = intOne + intTwo;
                    System.out.println("Answer: " + resultInt);
                }    
                else {
                    System.out.println(errorMsg);
                    return;
                }
                break;
            case "subtract":
                // If the user is performing an add/subtract operation, prompt the user to enter two integers.
                System.out.println("Enter two integers: ");

                if (sc.hasNextInt())
                    intOne = sc.nextInt();
                if (sc.hasNextInt()) {
                    intTwo = sc.nextInt();
                    resultInt = intOne - intTwo;
                    System.out.println("Answer: " + resultInt);
                }
                else {
                    System.out.println(errorMsg);
                    return;
                }
                break;
            case "multiply":
                // If the user is performing a multiply/divide operation, prompt the user to enter two doubles.
                System.out.println("Enter two doubles: ");

                if (sc.hasNextDouble())
                    dblOne = sc.nextDouble();
                if (sc.hasNextDouble()) {
                    dblTwo = sc.nextDouble();
                    resultDbl = dblOne * dblTwo;
                    System.out.printf("Answer: %.2f", resultDbl);
                }
                else {
                    System.out.println(errorMsg);
                    return;
                }
                break;
            case "divide":
                // If the user is performing a multiply/divide operation, prompt the user to enter two doubles.
                System.out.println("Enter two doubles: ");

                if (sc.hasNextDouble())
                    dblOne = sc.nextDouble();
                if (sc.hasNextDouble()) {
                    dblTwo = sc.nextDouble();
                    if (dblTwo != 0.0) {
                        resultDbl = dblOne / dblTwo;
                        System.out.printf("Answer: %.2f", resultDbl);
                    }
                    else {
                        System.out.println(errorMsg);
                        return;
                    } 
                }
                else {
                    System.out.println(errorMsg);
                    return;
                }
                break;
            case "alphabetize":
                // If the user is performing an alphabetize operation, prompt the user to enter two words.
                System.out.println("Enter two words: ");
                String input = sc.nextLine();
                String[] words = input.split(" ");

                for (int i=0; i < 2; i++) {
                    words[i] = words[i].replaceAll("^\"|\"$", "");
                }
                if ((words.length == 2) && (input.matches("[a-zA-Z\\s\\n\"]+"))) {
                    int compareWords = words[0].compareTo(words[1]);
                    if ((compareWords == 0) || (words[0].equalsIgnoreCase(words[1]))) {
                        System.out.println("Answer: Chicken or Egg.");
                    }
                    else if (compareWords < 0) {
                        System.out.println("Answer: " + words[0] + " comes before " + words[1] + " alphabetically.");
                    }
                    else {
                        System.out.println("Answer: " + words[1] + " comes before " + words[0] + " alphabetically.");
                    }
                }
                else {
                    System.out.println(errorMsg);
                    return;
                }
                break;
            default:
                // If the user enters an invalid operation, the program should print the following error message and terminate gracefully. "Invalid input entered. Terminating..."
                System.out.println(errorMsg);
                return;
        } 
        return;
    }
}