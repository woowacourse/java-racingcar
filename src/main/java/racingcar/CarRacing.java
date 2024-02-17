package racingcar;

import racingcar.domain.Car;
import racingcar.domain.CarAccelerator;
import racingcar.domain.Cars;
import racingcar.domain.Referee;
import racingcar.domain.TryCount;
import racingcar.io.InputView;
import racingcar.io.OutputView;

import java.util.ArrayList;
import java.util.List;


public class CarRacing {
    private final InputView inputView;
    private final OutputView outputView;

    public CarRacing(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Cars cars = createCars(inputView.readCarNames());
        TryCount tryCount = createTryCount(inputView.readTryAmount());

        printMoveResult(tryCount, cars);
        printWinners(cars);
    }

    private void printWinners(Cars cars) {
        outputView.printWinners(Referee.getWinners(cars));
    }

    private void printMoveResult(TryCount tryCount, Cars cars) {
        outputView.printMoveResultMessage();
        tryMove(tryCount, cars);
    }

    private Cars createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return new Cars(cars);
    }

    private TryCount createTryCount(int amount) {
        return new TryCount(amount);
    }

    private void tryMove(TryCount tryCount, Cars cars) {
        for (int i = 0; i < tryCount.getValue(); i++) {
            cars.tryMove(new CarAccelerator());
            outputView.printCarsPosition(cars.getCars());
        }
    }
}
