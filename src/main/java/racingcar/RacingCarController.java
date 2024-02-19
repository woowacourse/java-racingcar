package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.domain.movestrategy.RandomDigitSupplier;
import racingcar.domain.movestrategy.CarMoveStrategy;
import racingcar.domain.TrialCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private RacingCarController() {
    }

    public static void run() {
        final Racing racing = inputCars();
        final TrialCount trialCount = inputTrialCount();

        OutputView.printResultTitle();
        trialCount.repeat(() -> progressRacing(racing));

        final List<Car> winners = racing.findWinner();
        OutputView.printWinners(winners);
    }

    private static Racing inputCars() {
        try {
            final List<String> carNames = InputView.inputNames();
            return Racing.of(carNames, new CarMoveStrategy(new RandomDigitSupplier()));
        } catch (final IllegalArgumentException exception) {
            OutputView.printException(exception);
            return inputCars();
        }
    }

    private static TrialCount inputTrialCount() {
        try {
            final int trialAmount = InputView.inputTryCount();
            return new TrialCount(trialAmount);
        } catch (final IllegalArgumentException exception) {
            OutputView.printException(exception);
            return inputTrialCount();
        }
    }

    private static void progressRacing(final Racing racing) {
        racing.move();
        OutputView.printProgress(racing.getCars());
    }
}
