import controller.RaceController;
import ui.InputView;
import ui.OutputView;
import util.InputDelimiterValidator;
import util.InputIntegerValidator;
import util.NumberGenerator;
import util.RandomNumberGenerator;

public class Main {
    public static void main(String[] args) {
        final InputView inputView = new InputView(new InputDelimiterValidator(), new InputIntegerValidator());
        final OutputView outputView = new OutputView();
        final NumberGenerator numberGenerator = new RandomNumberGenerator();
        final RaceController raceController = new RaceController(numberGenerator, inputView, outputView);
        raceController.start();
    }
}
