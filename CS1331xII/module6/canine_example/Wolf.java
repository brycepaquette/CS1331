import java.util.Arrays;

public class Wolf extends Canine implements Comparable<Wolf> {
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

    public void groom() {
        System.out.println("lick");
    }

    public int compareTo(Wolf otherWolf) {
        return -(rank - otherWolf.rank);
    }

    public String toString() {
        return String.format("Rank %d, Size %.2f", rank, size);
    }

    public static void main(String[] args) {
        Wolf[] pack = {
            new Wolf(17.1, 2),
            new Wolf(3, 10),
            new Wolf(9.2, 7),
            new Wolf(9.1, 8),
            new Wolf(17.01, 3),
            new Wolf(16.2, 1),
            new Wolf(16, 4),
            new Wolf(16, 5),
            new Wolf(10, 6),
            new Wolf(5, 9)
        };

        System.out.println(String.format("Unsorted Pack: %s", (Arrays.toString(pack))));
        Arrays.sort(pack);
        System.out.println(String.format("Sorted Pack: %s", Arrays.toString(pack)));
        
    }
    // public static void main(String[] args) {
    //     Wolf alpha = new Wolf(17.1, 1);
    //     Wolf puppy = new Wolf(3, 10);
    //     System.out.println(alpha.compareTo(puppy));
    // }

    // public static void main(String[] args) {
    //     Wolf alpha = new Wolf(17.1, 1);
    //     alpha.bark();
    // }
}
