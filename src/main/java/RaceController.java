import domain.Attempts;
import domain.RacingGame;
import dto.ResultDto;
import view.InputView;
import view.OutputView;

import java.io.IOException;
import java.util.List;

public class RaceController {
    private static final InputView inputView = new InputView(System.in);

    public static void main(String[] args) {
        final RacingGame racingGame = repeatUntilGetValidCarNames();
        final Attempts attempts = repeatUntilGetValidAttempts();

        List<ResultDto> raceProcess = racingGame.race(attempts);

        OutputView.printRaceProcess(raceProcess);
        OutputView.printResult(racingGame.getResult());
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
