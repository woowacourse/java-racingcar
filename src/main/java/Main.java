import controller.GameController;
import util.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        GameController gameController = new GameController(inputView, outputView, randomNumberGenerator);

        gameController.startGame();
    }
}
