public class Gameplay {
    public static void main(String[] args) {
        BlueAstronaut bobBlueAstro = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut heathBlueAstro = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut albertBlueAstro = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut angelBlueAstro = new BlueAstronaut("Angel", 0, 1, 0);
        RedAstronaut liamRedAstro = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut susRedAstro = new RedAstronaut("Suspicious Person", 100, "expert");

        liamRedAstro.sabotage(bobBlueAstro);
        print(bobBlueAstro.toString());
        // sus 30, not frozen

        liamRedAstro.freeze(susRedAstro);
        // nothing should happen. susRedAstro should not be frozen
        print(susRedAstro.toString());

        liamRedAstro.freeze(albertBlueAstro);
        // liam sus level is 19, albert is frozen
        print(liamRedAstro.toString());
        print(albertBlueAstro.toString());

        albertBlueAstro.emergencyMeeting();
        // nothing should happen since he is frozen

        susRedAstro.emergencyMeeting();
        // results in a tie between Bob and Heath, nothing should happen

        bobBlueAstro.emergencyMeeting();
        // susRedAstro should be frozen
        print(susRedAstro.toString());

        heathBlueAstro.completeTask();
        // numTasks = 1
        print(heathBlueAstro.toString());

        heathBlueAstro.completeTask();
        // prints I have completed my tasks. numTasks = 0, susLevel = 15

        heathBlueAstro.completeTask();
        // nothing should happen

        liamRedAstro.freeze(angelBlueAstro);
        // angel not frozen, liam susLevel 38
        print(angelBlueAstro.toString());
        print(liamRedAstro.toString());

        liamRedAstro.sabotage(bobBlueAstro);
        liamRedAstro.sabotage(bobBlueAstro);
        // bob has susLevel 46 (30->37->46)
        print(bobBlueAstro.toString());

        liamRedAstro.freeze(bobBlueAstro);
        // bob is frozen
        print(bobBlueAstro.toString());

        for (int i = 0; i < 5; i++) {
            liamRedAstro.sabotage(heathBlueAstro);
        }
        // heath sus = 41
        print(heathBlueAstro.toString());
        
        liamRedAstro.freeze(heathBlueAstro);
        // Heath is frozen, "Imposters Win" is printed to the console        
    }

    private static void print(String s) {
        System.out.println(s);
    }
}
