import controller.RacingGame;
import view.InputView;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        final String[] carNames = InputView.getCarNames();
        final int tryCount = InputView.getTryCount();
        System.out.println();

        RacingGame racingGame = new RacingGame(carNames, tryCount);
        racingGame.start();
        ResultView.printWinners(racingGame.getWinners());
    }
}
