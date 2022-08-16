import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
    
    // variables
    private String skill; // represents the skill of a Red crewmate as a String value of either inexperienced, experienced, or expert.
    public static final int DEFAULT_SUS = 15;
    public static final String DEFAULT_SKILL = "experienced";

    // constructors
    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill.toLowerCase();
    }

    public RedAstronaut(String name) {
        this(name, DEFAULT_SUS, DEFAULT_SKILL);
    }

    // methods
    public void emergencyMeeting() {
        if (isFrozen()) { return; }

        Player[] players = Player.getPlayers();
        Arrays.sort(players);
        int suspectIndex = players.length - 1;
        Player suspect = players[suspectIndex];

        while (suspect.isFrozen() || super.equals(suspect)) {
            suspectIndex--;
            suspect = players[suspectIndex];
        }
        int suspectSusLevel = suspect.getSusLevel();
        int nextHighestSusIndex = suspectIndex - 1;
        Player nextHighestPlayer = players[nextHighestSusIndex];

        while (nextHighestPlayer.isFrozen() && nextHighestPlayer.getSusLevel() == suspectSusLevel) {
            nextHighestSusIndex--;
            nextHighestPlayer.isFrozen();
        }

        if (suspectSusLevel == nextHighestPlayer.getSusLevel()) {
            return;
        }
        else {
            suspect.setFrozen(true);
        }        
        super.gameOver();
    }

    public void freeze(Player p) {
        
        int redAstroSusLevel = super.getSusLevel();
        if (super.isFrozen() || p instanceof Impostor || p.isFrozen()) {
            return;
        }
        if (redAstroSusLevel < p.getSusLevel()){
            p.setFrozen(true);
        }
        else {
            super.setSusLevel(redAstroSusLevel * 2);
        }
        super.gameOver();
    }

    public void sabotage(Player p) {
        if (super.isFrozen() || p instanceof Impostor || p.isFrozen()) {
            return;
        }
        
        int pSusLevel = p.getSusLevel();
        int newSusLevel;
        if (super.getSusLevel() < 20) {
            newSusLevel = (int) (pSusLevel * 1.5);
            p.setSusLevel(newSusLevel);
        }
        else {
            newSusLevel = (int) (pSusLevel * 1.25);
            p.setSusLevel(newSusLevel);
        }
    } 

    public boolean equals(Object o) {
        if (o instanceof RedAstronaut) {
            RedAstronaut otherRedAstro = (RedAstronaut) o;
            boolean playerVarsEqual = super.equals(o);
            boolean skillEqual = skill == otherRedAstro.skill;
            return (playerVarsEqual && skillEqual);
        }
        else {
            return false;
        }
    }

    public String toString() {
        String s = super.toString() + String.format("I am an %s player!", skill);
        s = super.getSusLevel() > 15 ? s.toUpperCase() : s;
        return s;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
