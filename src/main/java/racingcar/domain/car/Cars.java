package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.utils.RandomUtils;

public class Cars {

    private static final String COMMA = ",";

    private final List<Car> cars;

    private Cars(final String names) {
        this(convertToCars(names));
        validateBothEnds(names);
        validateDuplicate(names);
    }

    private Cars(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars enrollCarsWithNames(final String names) {
        validateNull(names);
        return new Cars(names);
    }

    private static List<Car> convertToCars(final String names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names.split(COMMA)) {
            cars.add(Car.enrollWithName(name));
        }
        return cars;
    }

    private static void validateNull(final String names) {
        if (names == null) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private void validateBothEnds(final String names) {
        if (names.startsWith(COMMA) || names.endsWith(COMMA)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private void validateDuplicate(final String names) {
        final List<String> namesList = new ArrayList<>(Arrays.asList(names.split(COMMA)));
        final Set<String> namesSet = new HashSet<>(namesList);
        if (namesList.size() != namesSet.size()) {
            throw new IllegalArgumentException("이름이 중복됩니다.");
        }
    }

    public Cars passOneLap() {
        List<Car> passedCars = new ArrayList<>();
        for (Car car : cars) {
            car = car.fillUpGas(RandomUtils.betweenZeroToNine());
            passedCars.add(car.forward());
        }
        return new Cars(passedCars);
    }

    public List<String> findWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
            .filter(car -> car.isWinner(maxPosition))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
            .map(Car::getPosition)
            .max(Integer::compareTo)
            .get();
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
