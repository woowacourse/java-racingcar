package racingcar;

import java.util.ArrayList;
import java.util.List;
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

    private void printMoveResult(TryCount tryCount, Cars cars) {
        outputView.printMoveResultMessage();
        tryMove(tryCount, cars);
    }

    private void tryMove(TryCount tryCount, Cars cars) {
        for (int i = 0; i < tryCount.getValue(); i++) {
            cars.tryMove(new CarAccelerator());
            outputView.printCarsPosition(cars.getCars());
        }
    }

    private void printWinners(Cars cars) {
        Referee referee = new Referee(cars.getCarsPosition());
        outputView.printWinners(referee.getWinners());
    }
}
