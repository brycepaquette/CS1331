public class Cat extends Pet {
    
    private int miceCaught;

    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);

        if (miceCaught < 0) {
            miceCaught = 0;
        }
        
        this.miceCaught = miceCaught;
    }

    public Cat(String name, double health, int painLevel) {
        super(name, health, painLevel);
        this.miceCaught = 0;
    }

    public int getMiceCaught() {
        return miceCaught;
    }

    public int treat() {
        super.heal();
        double minutes;
        int painLevel = super.getPainLevel();
        double health = super.getHealth();

        if (miceCaught < 4) {
            minutes = ((painLevel*2)/health);
        }
        else if (miceCaught <= 7) {
            minutes = painLevel/health;
        }
        else {
            minutes = (painLevel/(health*2));
        }

        return (int) Math.ceil(minutes);
    }

    public void Speak() {
        super.speak();
        int painLevel = super.getPainLevel();
        String word = "meow";
        String string = "";

        // Create string
        for (int i = 0; i < painLevel; i++) {
            if (i != (painLevel - 1)) {
                string.concat(word + " ");
            }
            else {
                string.concat(word);
            }  
        }
        
        string = painLevel > 5 ? string.toUpperCase() : string;

        System.out.println(string);
    }

    public boolean equals(Object o) {
        boolean result = false;

        if (o instanceof Cat) {
            Cat cat2 = (Cat) o;
            result = ((super.equals(cat2)) && miceCaught == cat2.miceCaught);
        }

        return result;
    }

}
