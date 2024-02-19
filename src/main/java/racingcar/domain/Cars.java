package racingcar.domain;

import racingcar.util.RandomGenerator;

import java.util.Collections;
import java.util.List;

public class Cars {

    private static final String MESSAGE_NOT_EXIST_CAR = "생성된 자동차가 없습니다.";
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MINIMUM_MOVEMENT_CONDITION = 4;
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }

    public int calculateLongestDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(MESSAGE_NOT_EXIST_CAR));
    }

    public List<String> findWinners(int longestDistance) {
        return cars.stream()
                .filter(car -> car.getDistance() == longestDistance)
                .map(Car::getName)
                .toList();
    }

    public static Cars makeNewCars(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .toList());
    }

    public void moveCars() {
        for (Car car : cars) {
            moveCar(car);
        }
    }

    private void moveCar(Car car) {
        if (RandomGenerator.generateRandomNumber(MAX_RANDOM_NUMBER + 1) >= MINIMUM_MOVEMENT_CONDITION) {
            car.moveCar();
        }
    }
}
