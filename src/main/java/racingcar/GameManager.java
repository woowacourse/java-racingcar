package racingcar;

import racingcar.condition.RandomCondition;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static final String MESSAGE_NOT_EXIST_CAR = "생성된 자동차가 없습니다.";
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void run() {
        List<Car> cars = getCars();
        int tryCount = inputView.getTryCount();

        outputView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars);
            outputView.printTryResult(cars);
        }

        List<Car> winners = decideWinners(cars);
        outputView.printWinners(winners);
    }

    private List<Car> getCars() {
        List<Car> cars;
        try {
            cars = makeNewCars(inputView.getCarName());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            cars = getCars();
        }
        return cars;
    }

    private List<Car> makeNewCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.moveCar(new RandomCondition());
        }
    }

    private List<Car> decideWinners(List<Car> cars) {
        int longestDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(MESSAGE_NOT_EXIST_CAR));

        return cars.stream()
                .filter(car -> car.getDistance() == longestDistance)
                .toList();
    }
}
