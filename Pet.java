public abstract class Pet {

    private String name;    
    private double health; // A percentage value ranging from 0.0 to 1.0
    private int painLevel; // Ranges from 1 to 10

    public Pet(String name, double health, int painLevel) {
        
        // If the health value passed is not within the bounds, set to the closest bound
        if (health < 0) {
            health = 0;
        }
        else if (health > 1) {
            health = 1;
        }

        // If the painLevel value passed is not within the bounds, set to the closest bound
        if (painLevel < 1) {
            painLevel = 1;
        }
        else if (painLevel > 10) {
            painLevel = 10;
        }

        this.name = name;
        this.health = health;
        this.painLevel = painLevel;
    }

    // Getter Methods
    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public int getPainLevel() {
        return painLevel;
    }

}