package racingcar.domain;

import java.util.List;

public class Cars {

    private static final String MESSAGE_NOT_EXIST_CAR = "생성된 자동차가 없습니다.";
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars makeNewCars(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .toList());
    }

    public static void moveRandomly(Car car, MoveCondition moveCondition) {
        if (moveCondition.isMovable()) {
            car.move();
        }
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


    public void moveCars() {
        for (Car car : cars) {
            moveRandomly(car, RandomMoveCondition.getInstance());
        }
    }


    public List<Car> getCars() {
        return List.copyOf(cars);
    }
}
