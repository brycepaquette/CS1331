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
        super(name, DEFAULT_SUS);
        this.skill = DEFAULT_SKILL;
    }

    // methods
    public void emergencyMeeting() {
        if (isFrozen()) {
            return;
        }
        Player[] players = Player.getPlayers();
        Arrays.sort(players);
        String imposterName = getName();
        int suspectIndex = players.length - 1;
        Player suspect = players[suspectIndex];

        while (suspect.isFrozen() || suspect.getName() == imposterName) {
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
        suspect.gameOver();
    }

    public void freeze(Player p) {
        
        if (isFrozen() || p instanceof Impostor || p.isFrozen()) {
            return;
        }
        else{
            p.setFrozen(true);
        }
    }

    public void sabotage(Player p) {
        if (isFrozen() || p instanceof Impostor || p.isFrozen()) {
            return;
        }
        
        int pSusLevel = p.getSusLevel();
        int newSusLevel;
        if (getSusLevel() < 20) {
            newSusLevel = (int) (pSusLevel * 1.5);
            p.setSusLevel(newSusLevel);
        }
        else {
            newSusLevel = (int) (pSusLevel * 1.25);
            p.setSusLevel(newSusLevel);
        }
    } 

    public boolean equals(Object o) {
        RedAstronaut otherRedAstro = (RedAstronaut) o;
        boolean nameEqual = getName() == otherRedAstro.getName();
        boolean frozenEqual = isFrozen() == otherRedAstro.isFrozen();
        boolean susLevelEqual = getSusLevel() == otherRedAstro.getSusLevel();
        boolean skillEqual = skill == otherRedAstro.skill;

        return (nameEqual && frozenEqual && susLevelEqual && skillEqual);
    }

    public String toString() {
        String frozenStr = isFrozen() ? "frozen" : "not frozen";
        return String.format("My name is %s, and I have a suslevel of %d. I am currently %s. I am an %s player!", getName(), getSusLevel(), frozenStr, skill);
    }

    public String getSkill() {
        return skill;
    }

    public void setString(String skill) {
        this.skill = skill;
    }
}
