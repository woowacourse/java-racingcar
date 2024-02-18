import domain.Attempts;
import domain.CarGroup;
import domain.RacingGame;
import utils.PowerGenerator;
import utils.RandomPowerGenerator;
import view.InputView;
import view.OutputView;

import java.io.IOException;

import static java.util.stream.IntStream.range;

public class Application {
    private static final InputView inputView = new InputView(System.in);
    private static final PowerGenerator powerGenerator = new RandomPowerGenerator();

    public static void main(String[] args) {
        final CarGroup carGroup = repeatUntilGetValidCarNames();
        final Attempts attempts = repeatUntilGetValidNumberOfAttempts();

        OutputView.printRaceResultHeader();
        race(carGroup, attempts);
        OutputView.printResult(carGroup);
    }

    private static void race(CarGroup carGroup, Attempts attempts) {
        final RacingGame racingGame = new RacingGame(carGroup, powerGenerator);
        int numberOfAttempts = attempts.numberOfAttempts();

        range(0, numberOfAttempts).forEach(i -> {
            racingGame.moveCars();
            OutputView.printCarsPosition(carGroup);
        });
    }

    private static CarGroup repeatUntilGetValidCarNames() {
        try {
            String[] carNames = inputView.readCarNames();
            return new CarGroup(carNames);
        } catch (IOException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeatUntilGetValidCarNames();
        }
    }

    private static Attempts repeatUntilGetValidNumberOfAttempts() {
        try {
            Integer numberOfAttempts = inputView.readNumberOfAttempts();
            return new Attempts(numberOfAttempts);
        } catch (IOException | IllegalArgumentException e) {
            return repeatUntilGetValidNumberOfAttempts();
        }
    }
}
