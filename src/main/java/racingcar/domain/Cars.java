package racingcar.domain;

import racingcar.dto.CarPerformance;
import racingcar.dto.RoundResult;

import java.util.Collections;
import java.util.List;

import static racingcar.constant.ExceptionMessage.DUPLICATED_CAR_NAME;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateUniqueCarNames(cars);
        this.cars = Collections.unmodifiableList(cars);
    }

    public static Cars createCarsByName(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        return new Cars(cars);
    }

    public RoundResult moveCars() {
        List<CarPerformance> carPerformances = cars.stream()
                .map(this::moveCar)
                .toList();

        return new RoundResult(carPerformances);
    }

    public List<String> getWinnersName() {
        int maxDistance = findMaxDistance();

        return cars.stream()
                .filter(car -> car.isSameDistance(maxDistance))
                .map(Car::getName)
                .toList();
    }

    private void validateUniqueCarNames(List<Car> cars) {
        int uniqueCarNamesCount = (int)cars.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (uniqueCarNamesCount != cars.size()) {
            throw DUPLICATED_CAR_NAME.getException();
        }
    }

    private CarPerformance moveCar(Car car) {
        int oil = RandomOilGenerator.generate();
        car.goIfOilEnough(oil);

        return car.getCurrentPerformance();
    }

    private int findMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getMovedDistance)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }
}
