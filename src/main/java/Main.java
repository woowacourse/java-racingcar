import domain.RacingGame;
import view.InputView;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingGame racingGame = new RacingGame(inputView, outputView);

        racingGame.run();
    }
}
