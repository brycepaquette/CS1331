import java.util.ArrayList;

public class Sandbox {
    public static void main(String args[]) {
        ArrayList<String> playlist = new ArrayList<>();
        playlist.add("Humpty Dumpty");
        playlist.add("Swing Low Sweet Chariot");
        playlist.remove("Humpty Dumpty");
        System.out.println(playlist);
    }
}