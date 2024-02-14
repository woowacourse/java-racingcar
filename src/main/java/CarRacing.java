import domain.Car;
import domain.Cars;
import domain.TryCount;
import io.InputView;
import io.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRacing {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Cars cars = createCars(inputView.readCarNames());
        TryCount tryCount = createTryCount(inputView.readTryAmount());

        printMoveResult(tryCount, cars);
        printWinners(cars);
    }

    private static void printWinners(Cars cars) {
        outputView.printWinners(getWinners(cars));
    }

    private static void printMoveResult(TryCount tryCount, Cars cars) {
        outputView.printMoveResultMessage();
        tryMove(tryCount, cars);
    }

    public static Cars createCars(String carNames) {
        return new Cars(Arrays.asList(carNames.split(",")));
    }

    public static TryCount createTryCount(int amount) {
        return new TryCount(amount);
    }

    public static void tryMove(TryCount tryCount, Cars cars) {
        for (int i = 0; i < tryCount.getAmount(); i++) {
            cars.tryMove();
            outputView.printCarsPosition(cars.getCars());
        }
    }

    public static List<String> getWinners(Cars cars) {
        int maxPosition = cars.getCarsMaxPosition();

        List<String> winners = new ArrayList<>();
        for (Car car : cars.getCars()) {
            if(car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
