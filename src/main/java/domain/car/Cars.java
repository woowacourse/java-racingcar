package domain.car;

import domain.racing.RacingRule;
import domain.random.RandomNumberGeneratorImpl;
import dto.CarStatus;

import java.util.HashSet;
import java.util.List;

public class Cars {

    private final List<Car> cars;
    private final RacingRule racingRule = new RacingRule();

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> carNames) {
        validateCarNamesCount(carNames);
        validateDuplicatedCarNames(carNames);
        List<Car> cars = initCars(carNames);

        return new Cars(cars);
    }

    private static void validateCarNamesCount(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("자동차 이름의 개수는 2이상이여야 합니다.");
        }
    }

    private static void validateDuplicatedCarNames(List<String> carNames) {
        int distinctSize = new HashSet<>(carNames).size();

        if (carNames.size() != distinctSize) {
            throw new IllegalArgumentException("중복된 자동차 이름을 허용하지 않습니다.");
        }
    }

    private static List<Car> initCars(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(new RandomNumberGeneratorImpl(), name))
                .toList();
    }

    public List<CarStatus> race() {
        return cars.stream()
                .peek(Car::move)
                .map(Car::getStatus)
                .toList();
    }

    public List<String> findWinnerNames() {
        return racingRule.findWinnerCars(cars)
                .stream()
                .map(Car::getName)
                .toList();
    }
}
