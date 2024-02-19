import domain.Car;
import domain.Race;
import domain.RandomDigitSupplier;
import domain.TrialCount;
import java.util.List;
import view.InputView;
import view.OutputView;

public class RacingCarController {

    public static void run() {
        Race cars = inputCars();
        TrialCount trialCount = inputTrialCount();

        OutputView.printResultTitle();
        trialCount.repeat(() -> progressRacing(cars));

        List<Car> winners = cars.findWinner();
        OutputView.printWinners(winners);
    }

    private static Race inputCars() {
        try {
            List<Car> cars = InputView.inputNames()
                    .stream()
                    .map(Car::new)
                    .toList();
            return new Race(cars, new RandomDigitSupplier());
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

    private static void progressRacing(Race cars) {
        cars.move();
        OutputView.printProgress(cars.getCars());
    }
}
