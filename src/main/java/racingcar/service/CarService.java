package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarService {
    private Cars cars;

    public void initializeCars() {
        cars = new Cars(new ArrayList<Car>());
    }

    public void makeCar(List<String> carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName, 0);
            cars.addCar(car);
        }
    }

    public void validateNegativeCount(int tryCount) {
        int minTryCount = Car.MIN_TRY_COUNT;
        if (tryCount <= minTryCount) {
            throw new IllegalArgumentException(String.format("[ERROR] 시도할 횟수는 %d보다 큰 숫자여야 합니다.", minTryCount));
        }
    }

    public List<Car> getCarsStatus() {
        return cars.getCars();
    }

    public void runRound(MoveStrategy moveStrategy, int round) {
        for (Car car : cars.getCars()) {
            runForward(moveStrategy, car, round);
        }
    }

    public void runForward(MoveStrategy moveStrategy, Car car, int round) {
        if (moveStrategy.isMovable()) {
            car.movePosition(round);
        }
    }

    public List<String> findWinner() {
        return cars.getWinner();
    }
}
