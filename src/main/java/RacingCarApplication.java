import racingcar.controller.GameManager;
import racingcar.view.InputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        String[] carNames = InputView.inputCarName();
        int round = InputView.inputRound();

        GameManager gameManager = new GameManager(carNames, round);
        gameManager.startGame();
    }
}
