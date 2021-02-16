import racingcar.controller.RacingGameController;
import racingcar.domain.RacingGameResult;
import racingcar.view.ConsoleInputView;
import racingcar.view.GameResultView;

public class Application {

    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();

        try {
            RacingGameResult gameResult = racingGameController.startRacingGame(
                    ConsoleInputView.getInputCarsName(),
                    ConsoleInputView.getInputTurns()
            );

            GameResultView.printGameResult(gameResult);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
