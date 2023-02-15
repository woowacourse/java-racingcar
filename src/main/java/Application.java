import domain.RacingGame;
import utils.powerGenerator.RandomPowerGenerator;
import view.InputView;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        final RandomPowerGenerator randomPowerGenerator = new RandomPowerGenerator();
        final String[] carNames = InputView.getCarNames();
        final int tryCount = InputView.getTryCount();
        System.out.println();

        RacingGame racingGame = new RacingGame(carNames, tryCount, randomPowerGenerator);
        racingGame.start();
        ResultView.printWinners(racingGame.getWinners());
    }
}
