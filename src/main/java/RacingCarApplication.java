import racingcar.controller.GameManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        String[] carNames = InputView.inputCarName();
        int round = InputView.inputRound();

        GameManager gameManager = new GameManager(carNames, round);
        OutputView.printBeginResult();
        while (gameManager.isNotEnd()) {
            gameManager.race();
        }

        OutputView.printWinners(gameManager.getWinners());
    }
}
