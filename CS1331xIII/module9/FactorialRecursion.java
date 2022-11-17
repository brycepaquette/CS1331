public class FactorialRecursion {
    
    public static int factorial(int n) {
        if(n >= 0) {
            return realFactorial(n);
        }
        else {
            throw new IllegalArgumentException("Non-negative input required");
        }
    }
    
    private static int realFactorial(int n) {       
        if(n == 0) {
            return 1;
        }
        else {
            return n * realFactorial(n - 1);  
        }
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
