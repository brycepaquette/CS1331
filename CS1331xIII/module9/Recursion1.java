public class Recursion1 {
    
    public static void recursionPrint(String string, int times) {
        if(times <= 0) {
            return;
        }
        System.out.println(string);
        recursionPrint(string, times - 1);
    }

    public static void main(String[] args) {
        recursionPrint("Hello!", 5);
    }
}
