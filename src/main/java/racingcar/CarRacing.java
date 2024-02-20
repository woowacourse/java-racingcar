package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarAccelerator;
import racingcar.domain.Cars;
import racingcar.domain.Referee;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class CarRacing {
    private final InputView inputView;
    private final OutputView outputView;

    public CarRacing(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        final Cars cars = createCars(inputView.readCarNames());
        final TryCount tryCount = createTryCount(inputView.readTryAmount());

        printMoveResult(tryCount, cars);
        printWinners(cars);
    }

    private Cars createCars(final List<String> carNames) {
        final List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    private TryCount createTryCount(final int amount) {
        return new TryCount(amount);
    }

    private void printMoveResult(final TryCount tryCount, final Cars cars) {
        outputView.printMoveResultMessage();
        tryMove(tryCount, cars);
    }

    private void tryMove(final TryCount tryCount, final Cars cars) {
        for (int i = 0; i < tryCount.getValue(); i++) {
            cars.tryMove(new CarAccelerator());
            printCarsPosition(cars.getCars());
        }
    }

    private void printCarsPosition(final List<Car> cars) {
        for (final Car car : cars) {
            outputView.printCarPosition(car.getName(), car.getPosition());
        }
        outputView.printNewLine();
    }

    private void printWinners(final Cars cars) {
        final Referee referee = new Referee(cars.getCarsPosition());
        outputView.printWinners(referee.getWinners());
    }
}
