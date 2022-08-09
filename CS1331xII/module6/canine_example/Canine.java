public class Canine implements Groomable {
    protected double size;
    public Canine(double size) {
        this.size = size;
    }
    public void bark() {
        System.out.println("WOOF WOOF!");
    }

    public void groom() {
        System.out.println("DEFAULT CANINE GROOM");
    }
}