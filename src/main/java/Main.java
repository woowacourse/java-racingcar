import controller.RaceController;
import ui.InputView;
import ui.OutputView;
import util.CarNamesValidator;
import util.NumberGenerator;
import util.RandomNumberGenerator;
import util.TryCountValidator;

public class Main {
    public static void main(String[] args) {
        final InputView inputView = new InputView(new CarNamesValidator(), new TryCountValidator());
        final OutputView outputView = new OutputView();
        final NumberGenerator numberGenerator = new RandomNumberGenerator();
        final RaceController raceController = new RaceController(numberGenerator, inputView, outputView);
        raceController.start();
    }
}
