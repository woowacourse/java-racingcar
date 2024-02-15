package domain;

import java.util.HashSet;
import java.util.List;

public class CarFactory {

    private static final RandomNumberGenerator randomNumberGenerator = new RandomNumberGeneratorImpl();

    public static Cars generateCars(final List<String> carNames) {
        validateCarNamesCount(carNames);
        validateDuplicatedCarNames(carNames);

        final List<Car> cars = carNames.stream()
                .map(name -> new Car(randomNumberGenerator, name))
                .toList();

        return new Cars(cars);
    }

    private static void validateCarNamesCount(final List<String> carNames) {
        if (carNames.size() < 2) {
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
