import controller.GameManager;
import view.InputView;
import view.OutputView;

public class RacingCarApplication {


    public static void main(String[] args) {
        GameManager gameManager = new GameManager(InputView.inputCarNames(), InputView.inputRound());

        OutputView.printGameStartMessage();
        while (!gameManager.isFinish()) {
            gameManager.race();
            OutputView.printScore(gameManager.getCars());
        }
        OutputView.printWinner(gameManager.whoIsWinner());
    }
}
