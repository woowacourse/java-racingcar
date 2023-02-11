import controller.RacingGameController;
import domain.RandomMovingPolicy;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController(new InputView(),
                                                                            new OutputView(),
                                                                            new RandomMovingPolicy());

        racingGameController.run();
    }
}
