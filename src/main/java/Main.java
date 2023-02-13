import controller.RacingGameController;
import strategy.RandomMovingStrategy;
import view.InputView;
import view.OutputView;

public class Main {

    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController(
            new InputView(),
            new OutputView(),
            new RandomMovingStrategy()
        );

        racingGameController.execute();
    }
}
