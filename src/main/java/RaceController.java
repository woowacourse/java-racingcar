import domain.Attempts;
import domain.CarGroup;
import domain.RacingGame;
import utils.RandomPowerGenerator;
import view.InputView;
import view.OutputView;

import java.io.IOException;

public class RaceController {
    private static final InputView inputView = new InputView(System.in);

    public static void main(String[] args) {
        final CarGroup carGroup = repeatUntilGetValidCarNames();
        final Attempts attempts = repeatUntilGetValidAttempts();

        OutputView.printRaceResultHeader();
        race(carGroup, attempts);
        OutputView.printResult(carGroup);
    }

    private static void race(final CarGroup carGroup, final Attempts attempts) {
        final RacingGame racingGame = new RacingGame(carGroup, new RandomPowerGenerator());

        while (attempts.isEnd()) {
            racingGame.moveCars();
            OutputView.printCarsPosition(carGroup);
            attempts.decrease();
        }
    }

    private static CarGroup repeatUntilGetValidCarNames() {
        try {
            final String[] carNames = inputView.readCarNames();
            return new CarGroup(carNames);
        } catch (IOException | IllegalArgumentException e) {
            OutputView.printExceptionMessage(e);
            return repeatUntilGetValidCarNames();
        }
    }

    private static Attempts repeatUntilGetValidAttempts() {
        try {
            final Integer numberOfAttempts = inputView.readNumberOfAttempts();
            return new Attempts(numberOfAttempts);
        } catch (IOException | IllegalArgumentException e) {
            OutputView.printExceptionMessage(e);
            return repeatUntilGetValidAttempts();
        }
    }
}
