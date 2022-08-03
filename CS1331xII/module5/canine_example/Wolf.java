public class Wolf extends Canine {
    protected int rank;

    public Wolf( double size, int rank) {
        super(size);
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void bark() {
        for (int i = 0; i < 3; i++) {
            super.bark();
        }
    }

    public static void main(String[] args) {
        Wolf alpha = new Wolf(17.1, 1);
        alpha.bark();
    }
}
