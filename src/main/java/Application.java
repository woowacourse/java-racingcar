import controller.RacingGameController;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController(new InputView(), new OutputView());

        racingGameController.init();
        racingGameController.run();
    }
}
