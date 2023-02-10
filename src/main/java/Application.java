import controller.Controller;
import service.RacingGameService;
import utils.numberGenerator.NumberGenerator;
import utils.numberGenerator.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingGameService racingGameService = new RacingGameService(randomNumberGenerator);

        Controller controller = new Controller(outputView, inputView, racingGameService);
        controller.run();
    }
}
