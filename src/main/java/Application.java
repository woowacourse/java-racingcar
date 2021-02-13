import racingcar.controller.RacingGameController2;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        RacingGameController2 racingGameController = new RacingGameController2();

        racingGameController.startRacingGame(
                InputView.getInputCarsName(),
                InputView.getInputTurns()
        );
    }
}
