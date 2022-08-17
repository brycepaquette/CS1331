import java.util.Scanner;

public class FarenheitToCelsius {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Farenheit value: ");
        int farenheit = input.nextInt();
        double celsius = (5.0/9) * (farenheit - 32);
        System.out.print("Celsius conversion: " + celsius); 
    }
}
