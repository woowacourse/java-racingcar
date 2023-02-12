import controller.RaceController;
import controller.RaceState;

public class RaceApplication {

    public static void main(String[] args) {
        RaceApplicationConfig config = new RaceApplicationConfig();
        RaceController controller = config.raceController();

        RaceState raceState = RaceState.INPUT_CARS_NAME;
        while (raceState.isRacing()) {
            raceState = controller.run(raceState);
        }
    }
}
