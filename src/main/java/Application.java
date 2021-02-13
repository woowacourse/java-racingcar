import racingcar.controller.RacingGameController;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();

        try {
            racingGameController.startRacingGame(
                    InputView.getInputCarsName(),
                    InputView.getInputTurns()
            );
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
