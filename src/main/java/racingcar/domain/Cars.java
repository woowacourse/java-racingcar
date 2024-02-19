package racingcar.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cars {
    private static final int MINIMUM_CARS_SIZE = 1;
    private static final int MAXIMUM_POSITION_CAR_INDEX = 0;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCars(cars);
        this.cars = cars;
    }

    private void validateCars(List<Car> cars) {
        if (cars.size() < MINIMUM_CARS_SIZE) {
            throw new IllegalArgumentException(
                    String.format("게임에 참여하는 자동차의 수는 최소 %d대 이상이어야 합니다.", MINIMUM_CARS_SIZE));
        }

        if (hasDuplicateCarName(cars)) {
            throw new IllegalArgumentException("게임에 참여하는 자동차들의 이름은 중복될 수 없습니다.");
        }
    }

    private boolean hasDuplicateCarName(List<Car> cars) {
        return cars.size() != cars.stream()
                .map(Car::getName)
                .distinct()
                .count();
    }

    public void moveCars(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generate()));
    }

    public List<Car> findCarsAtMaxPosition() {
        cars.sort(Comparator.reverseOrder());
        Car maxPositionCar = cars.get(MAXIMUM_POSITION_CAR_INDEX);

        return findCarsBy(maxPositionCar);
    }

    private List<Car> findCarsBy(Car standardCar) {
        return cars.stream()
                .filter(car -> car.isSamePosition(standardCar))
                .toList();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
