import domain.Attempts;
import domain.RacingGame;
import view.InputView;
import view.OutputView;

import java.io.IOException;

public class RaceController {
    private static final InputView inputView = new InputView(System.in);

    public static void main(String[] args) {
        final RacingGame racingGame = repeatUntilGetValidCarNames();
        final Attempts attempts = repeatUntilGetValidAttempts();

        OutputView.printRaceResultHeader();
        race(racingGame, attempts);
        OutputView.printResult(racingGame);
    }

    private static void race(final RacingGame racingGame, final Attempts attempts) {
        while (attempts.isEnd()) {
            racingGame.move();
            OutputView.printCarsPosition(racingGame);
            attempts.decrease();
        }
    }

    private static RacingGame repeatUntilGetValidCarNames() {
        try {
            final String[] carNames = inputView.readCarNames();
            return new RacingGame(carNames);
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
