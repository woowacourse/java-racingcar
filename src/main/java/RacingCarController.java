import domain.Car;
import domain.Cars;
import domain.RandomDigitSupplier;
import domain.RandomMoveStrategy;
import domain.TrialCount;
import java.util.List;
import view.InputView;
import view.OutputView;

public class RacingCarController {

    public static void run() {
        Cars cars = inputCars();
        TrialCount trialCount = inputTrialCount();

        trialCount.repeat(() -> progressRacing(cars));
        OutputView.printResultTitle();

        List<Car> winners = cars.findWinner();
        OutputView.printWinners(winners);
    }

    private static Cars inputCars() {
        try {
            List<String> carNames = InputView.inputNames();
            return Cars.of(carNames, new RandomMoveStrategy(new RandomDigitSupplier()));
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return inputCars();
        }
    }

    private static TrialCount inputTrialCount() {
        try {
            int trialAmount = InputView.inputTryCount();
            return new TrialCount(trialAmount);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return inputTrialCount();
        }
    }

    private static void progressRacing(Cars cars) {
        cars.move();
        OutputView.printProgress(cars.getCarList());
    }
}
