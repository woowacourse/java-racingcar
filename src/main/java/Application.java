import controller.RacingCarGame;
import view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingCarGame racingCarGame = new RacingCarGame(inputView);
        racingCarGame.run();
    }
}
