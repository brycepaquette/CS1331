import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
    
    // variables
    private int numTasks;
    private int taskSpeed;
    public static final int DEFAULT_SUS = 15;
    public static final int DEFAULT_NUM_TASKS = 6;
    public static final int DEFAULT_TASK_SPEED = 10;

    // constructors
    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }
    public BlueAstronaut(String name) {
        this(name, DEFAULT_SUS, DEFAULT_NUM_TASKS, DEFAULT_TASK_SPEED);
    }

    // methods
    public void emergencyMeeting() {
        if (isFrozen()) { return; }

        Player[] players = Player.getPlayers();
        Arrays.sort(players);
        String crewmateName = getName();
        int suspectIndex = players.length - 1;
        Player suspect = players[suspectIndex];

        while (suspect.isFrozen()) {
            suspectIndex--;
            suspect = players[suspectIndex];
        }
        int suspectSusLevel = suspect.getSusLevel();
        int nextHighestSusIndex = suspectIndex - 1;
        Player nextHighestPlayer = players[nextHighestSusIndex];

        while (nextHighestPlayer.isFrozen() && nextHighestPlayer.getSusLevel() == suspectSusLevel) {
            nextHighestSusIndex--;
            nextHighestPlayer = players[nextHighestSusIndex];
        }

        if (nextHighestPlayer.getSusLevel() == suspectSusLevel) {
            return;
        }
        else {
            suspect.setFrozen(true);
        }
        
    }

}
