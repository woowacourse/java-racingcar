import domain.Attempts;
import domain.CarGroup;
import domain.RacingGame;
import utils.RandomPowerGenerator;
import view.InputView;
import view.OutputView;

import java.io.IOException;

import static java.util.stream.IntStream.range;

public class RaceController {
    private static final InputView inputView = new InputView(System.in);

    public static void main(String[] args) {
        final CarGroup carGroup = repeatUntilGetValidCarNames();
        final Attempts attempts = repeatUntilGetValidAttempts();

        OutputView.printRaceResultHeader();
        race(carGroup, attempts);
        OutputView.printResult(carGroup);
    }

    private static void race(CarGroup carGroup, Attempts attempts) {
        final RacingGame racingGame = new RacingGame(carGroup, new RandomPowerGenerator());
        int numberOfAttempts = attempts.numberOfAttempts();

        range(0, numberOfAttempts).forEach(ignore -> {
            racingGame.moveCars();
            OutputView.printCarsPosition(carGroup);
        });
    }

    private static CarGroup repeatUntilGetValidCarNames() {
        try {
            String[] carNames = inputView.readCarNames();
            return new CarGroup(carNames);
        } catch (IOException | IllegalArgumentException e) {
            OutputView.printExceptionMessage(e);
            return repeatUntilGetValidCarNames();
        }
    }

    private static Attempts repeatUntilGetValidAttempts() {
        try {
            Integer numberOfAttempts = inputView.readNumberOfAttempts();
            return new Attempts(numberOfAttempts);
        } catch (IOException | IllegalArgumentException e) {
            OutputView.printExceptionMessage(e);
            return repeatUntilGetValidAttempts();
        }
    }
}
