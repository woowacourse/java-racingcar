import application.RaceService;
import controller.RaceController;
import util.RandomNumberGenerator;

public class Main {
    public static void main(String[] args) {
        final RaceService raceService = new RaceService(new RandomNumberGenerator());
        final RaceController raceController = new RaceController(raceService);
        raceController.start();
    }
}
