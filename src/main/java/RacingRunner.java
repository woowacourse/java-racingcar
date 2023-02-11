import controller.RaceController;
import java.util.Scanner;
import service.RaceService;
import utils.RacingRandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class RacingRunner {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();
        RaceService raceService = new RaceService();
        RaceController raceController = new RaceController(inputView, outputView, raceService);

        raceController.run(new RacingRandomNumberGenerator());
    }
}
