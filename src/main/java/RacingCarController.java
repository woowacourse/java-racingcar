import domain.Car;
import domain.Cars;
import domain.RandomDigitSupplier;
import domain.TrialCount;
import java.util.List;
import view.InputView;
import view.OutputView;

public class RacingCarController {

    public static void run() {
        List<String> carNames = InputView.inputNames();
        Cars cars = Cars.of(carNames, new RandomDigitSupplier());

        int trialAmount = InputView.inputTryCount();
        TrialCount trialCount = new TrialCount(trialAmount);
        trialCount.repeat(() -> progressRacing(cars));
        OutputView.printResultTitle();

        List<Car> winners = cars.findWinner(); // TODO findWinner 테스트 필요
        OutputView.printWinners(winners);
    }

    private static void progressRacing(Cars cars) {
        cars.moveRandomly();
        OutputView.printProgress(cars.getCarList());
    }
}
