import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Clinic {
    
    private File patientFile;
    private int day;

    public Clinic(File file) {
        this.patientFile = file;
        this.day = 1;
    }

    public Clinic(String fileName) {
        this(new File(fileName));
    }

    public String nextDay(File f) throws FileNotFoundException, InvalidPetException {
        Scanner reader = new Scanner(f);
        Scanner sc = new Scanner(System.in);
        String[] data;

        while (reader.hasNextLine()) {
            data = (reader.nextLine()).split(",");
            String name = data[0];
            String type = data[1];
            String time = data[3];
            double health;
            int painLevel;

            System.out.printf("Consultation for %s the %s at %s. What is the health of %s?\n", name, type, time, name);
            
            // Check for valid pet type
            boolean iscat = type != "Cat";
            boolean isdog = type != "Dog";
            if (!iscat && !isdog) {
                throw new InvalidPetException();
            }

            while (true) {
                if (sc.hasNextDouble()) {
                    health = sc.nextDouble();
                    break;
                }
            }

            // do {
            //     System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n", name);

            //     // if (sc.hasNextInt()) {
            //         try {
            //             painLevel = sc.nextInt();
            //         }
 
            //         catch (InputMismatchExcepton e) {
            //             continue;
            //         }
            //     // }
            // } while (!sc.hasNextInt());


        }
        return "PLACEHOLDER";
    }

    public String nextDay(String fileName) throws FileNotFoundException, InvalidPetException {
        return nextDay(new File(fileName));
    }

    public static void main(String[] args) throws FileNotFoundException, InvalidPetException {
        Clinic clinic = new Clinic("Patients.csv");
        clinic.nextDay("C:\\Users\\b.paquette\\Documents\\Github\\CS1331xI\\CS1331\\Appointments.csv");

    }
}
