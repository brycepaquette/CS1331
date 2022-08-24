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

    // Returns the time taken (in minutes) to treat the pet
    abstract int treat();

    public void speak() {
        String s = String.format("Hello! My name is %s", name);
        if (painLevel > 5) { s = s.toUpperCase(); }
        System.out.println(s);
    }

    public boolean equals(Object o) {
        if (o instanceof Pet) {
            Pet pet2 = (Pet) o;
            String name2 = pet2.getName();
            return name == name2;
        }
        else {
            return false;
        }
    }

    protected void heal() {
        health = 1.0;
        painLevel = 1;
    }
}