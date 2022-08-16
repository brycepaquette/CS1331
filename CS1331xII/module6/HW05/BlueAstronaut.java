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
        if (super.isFrozen()) { return; }

        Player[] players = Player.getPlayers();
        Arrays.sort(players);
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
        super.gameOver();
    }

    public void completeTask() {
        if (super.isFrozen() || numTasks == 0) { return; };

        if (taskSpeed > 20) {
            numTasks -= 2;
        }
        else {
            numTasks--;
        }

        numTasks = numTasks < 0 ? 0 : numTasks;

        if (numTasks == 0) {
            System.out.println("I have completed all my tasks.");
            int newSusLevel = (int) (super.getSusLevel() * 0.5);
            super.setSusLevel(newSusLevel);
        }
    }

    public boolean equals(Object o) {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut otherBlueAstro = (BlueAstronaut) o;
            boolean playerVarsEqual = super.equals(o);
            boolean numTasksEqual = numTasks == otherBlueAstro.numTasks;
            boolean taskSpeedEqual = taskSpeed == otherBlueAstro.taskSpeed;

            return (playerVarsEqual && numTasksEqual && taskSpeedEqual);
        }
        else {
            return false;
        }
        
    }

    public String toString() {
        String s = super.toString() + String.format("I have %d left over.", numTasks);
        s = super.getSusLevel() > 15 ? s.toUpperCase() : s; 
        return s;
    }

    public int getNumTasks() {
        return numTasks;
    }

    public int getTaskSpeed() {
        return taskSpeed;
    }

    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }

    public void setTaskSpeed(int taskSpeed) {
        this.taskSpeed = taskSpeed;
    }
}
