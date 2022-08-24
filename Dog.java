public class Dog extends Pet {
    
    private double droolRate;

    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);

        if (droolRate <= 0) {
            droolRate = 0.5;
        }

        this.droolRate = droolRate;
    }

    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, 5.0);
    }

    public double getDroolRate() {
        return droolRate;
    }

    public int treat() {
        super.heal();
        double minutes;
        int painLevel = super.getPainLevel();
        double health = super.getHealth();

        if (droolRate < 3.5) {
            minutes = (painLevel*2)/health;
        }
        else if (droolRate <= 7.5) {
            minutes = painLevel/health;
        }
        else {
            minutes = painLevel/(health*2);
        }

        return (int) (Math.ceil(minutes));
    }

    public void speak() {
        for (int i = 0; i < super.getPainLevel(); i++) {
            super.speak();
        }        
    }

    public boolean equals(Object o) {
        boolean result = false;

        if (o instanceof Dog) {
            Dog dog2 = (Dog) o;
            result = ((super.equals(dog2)) && droolRate == dog2.droolRate);
        }
        
        return result;
    }
}
