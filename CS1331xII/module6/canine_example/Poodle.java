public class Poodle extends Dog {
    private String favoriteShampoo;
    private String favoriteConditioner;

    public Poodle(String name, double size, String favoriteShampoo, String favoriteConditioner) {
        super(name, size);
        this.favoriteShampoo = favoriteShampoo;
        this.favoriteConditioner = favoriteConditioner;
    }

    public void groom() {
        System.out.println(String.format("%s ,rinse, %s wait 10 mins, dry and massage", favoriteShampoo, favoriteConditioner));
    }
}
