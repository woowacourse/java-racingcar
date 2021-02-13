import racingcar.controller.RacingGameController;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();

        racingGameController.startRacingGame(
                InputView.getInputCarsName(),
                InputView.getInputTurns()
        );
    }
}
