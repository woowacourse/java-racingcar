package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private static final String CAR_NAME_DUPLICATION_ERROR_MESSAGE
            = "[ERROR] 자동차 이름은 중복되지 않게 입력해 주세요.";

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars create(final List<Car> cars) {
        validate(cars);
        return new Cars(cars);
    }

    private static void validate(final List<Car> cars) {
        Set<Car> nonDuplicated = new HashSet<>(cars);

        if (nonDuplicated.size() != cars.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATION_ERROR_MESSAGE);
        }
    }

    public static Cars createByName(final List<String> carNames) {
        validateByName(carNames);

        final List<Car> cars = carNames.stream()
                .map(Name::new)
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    private static void validateByName(final List<String> carNames) {
        final Set<String> nonDuplicatedNames = new HashSet<>(carNames);

        if (nonDuplicatedNames.size() != carNames.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATION_ERROR_MESSAGE);
        }
    }

    public Cars move() {
        List<Car> collect = cars.stream()
                .map(Car::move)
                .collect(Collectors.toList());

        return new Cars(collect);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
