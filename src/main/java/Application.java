import controller.RaceController;
import utils.NumberGenerator;
import utils.RandomGenerator;
import view.InputView;
import view.OutputView;

public class Application {
    private static final InputView inputView = new InputView(System.in);
    private static final OutputView outputView = new OutputView();
    private static final NumberGenerator numberGenerator = new RandomGenerator();

    public static void main(String[] args) {
        RaceController raceController = new RaceController(inputView, outputView, numberGenerator);
        raceController.run();
    }
}
