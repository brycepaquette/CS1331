public class InvalidPetException extends Exception {
    
    public InvalidPetException(String s) {
        super(s);
    }

    public InvalidPetException() {
        this("Your pet is invalid!");
    }
}
