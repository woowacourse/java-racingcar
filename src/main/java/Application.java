import controller.RacingGameController;
import domain.RandomMovingPolicy;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController(new RandomMovingPolicy(), new InputView(), new OutputView());

        racingGameController.init();
        racingGameController.run();
    }
}
