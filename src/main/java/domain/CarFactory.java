package domain;

import java.util.HashSet;
import java.util.List;

public class CarFactory {

    public static final int MIN_CAR_NAMES_COUNT = 2;
    
    private static final NumberRangeGenerator NUMBER_RANGE_GENERATOR = new RandomNumberRangeGenerator();

    public static Cars generateCars(final List<String> carNames) {
        validateCarNamesCount(carNames);
        validateDuplicatedCarNames(carNames);

        final List<Car> cars = carNames.stream()
                .map(name -> new Car(NUMBER_RANGE_GENERATOR, name))
                .toList();

        return new Cars(cars);
    }

    private static void validateCarNamesCount(final List<String> carNames) {
        if (carNames.size() < MIN_CAR_NAMES_COUNT) {
            throw new IllegalArgumentException("자동차 이름의 개수는 2이상이여야 합니다.");
        }
    }

    private static void validateDuplicatedCarNames(final List<String> carNames) {
        final int distinctSize = new HashSet<>(carNames).size();
        if (carNames.size() != distinctSize) {
            throw new IllegalArgumentException("중복된 자동차 이름을 허용하지 않습니다.");
        }
    }
}
