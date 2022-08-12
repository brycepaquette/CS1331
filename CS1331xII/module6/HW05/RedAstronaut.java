import java.util.Arrays;

public class RedAstronaut extends Player {
    
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
}
