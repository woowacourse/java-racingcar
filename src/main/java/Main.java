import application.RaceService;
import controller.RaceController;
import util.RandomNumberGenerator;
import ui.InputView;
import ui.OutputView;

public class Main {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final RaceService raceService = new RaceService(new RandomNumberGenerator());
        final RaceController raceController = new RaceController(inputView, outputView, raceService);
        raceController.start();
    }
}
