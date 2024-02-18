import controller.RacingCarGame;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        RacingCarGame racingCarGame = new RacingCarGame(inputView, outputView);

        racingCarGame.start();
    }

}
