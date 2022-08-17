public class Bad2 {
    public static void main(String[] args) {
        int a = 1331;
        int b = 0;
        System.out.println("Welcome to \nCS 1331!");
        // BAD CODE: int c = a / b;
        int c = b / a;
        System.out.println("c is equal to: " + c);
    }
}