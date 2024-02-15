package domain;

import java.util.List;
import java.util.Set;

public class CarFactory {

    private static final RandomNumberGenerator randomNumberGenerator = new RandomNumberGeneratorImpl();

    public static Cars generateCars(List<String> carNames) {
        validateCarNamesCount(carNames);
        validateDuplicatedCarNames(carNames);

        List<Car> cars = carNames.stream()
                .map(name -> new Car(randomNumberGenerator, name))
                .toList();

        return new Cars(cars);
    }

    private static void validateCarNamesCount(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new RuntimeException("자동차 이름의 개수는 2이상이여야 합니다.");
        }
    }

    private static void validateDuplicatedCarNames(List<String> carNames) {
        int distinctSize = Set.of(carNames).size();

        if (carNames.size() != distinctSize) {
            throw new RuntimeException("중복된 자동차 이름을 허용하지 않습니다.");
        }
    }
}
