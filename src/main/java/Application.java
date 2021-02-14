import racingcar.controller.RacingGameController;
import racingcar.view.ConsoleInputView;

public class Application {

    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();

        try {
            racingGameController.startRacingGame(
                    ConsoleInputView.getInputCarsName(),
                    ConsoleInputView.getInputTurns()
            );
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
