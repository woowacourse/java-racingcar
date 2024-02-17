package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RandomGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    List<Car> cars = new ArrayList<>();

    public void run() {
        outputView.printCarNameInputMessage();
        List<String> carNames = inputView.getCarName();
        makeNewCars(carNames);
        outputView.printTryCountInputMessage();
        int tryCount = inputView.getTryCount();
        for (int i = 0; i < tryCount; i++) {
            moveCars();
            outputView.printTryResult(cars);
        }
        outputView.printWinners(cars);
    }

    private void moveCars() {
        for (Car car : cars) {
            car.moveCar(RandomGenerator.getRandomNumberUnderTen());
        }
    }

    private void makeNewCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }
}
