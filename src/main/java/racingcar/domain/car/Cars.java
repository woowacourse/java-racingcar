package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private static final String COMMA = ",";

    private final List<Car> cars;

    private Cars(final String names) {
        validateNull(names);
        validateBothEnds(names);
        validateDuplicate(names);
        this.cars = convertToCars(names);
    }

    public static Cars enrollCarsWithNames(final String names) {
        return new Cars(names);
    }

    private void validateNull(final String names) {
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

    private List<Car> convertToCars(final String names) {
        final List<Car> cars = new ArrayList<>();
        for (String name : names.split(COMMA)) {
            cars.add(Car.enrollWithName(name));
        }
        return cars;
    }

    public List<String> getWinners() {
        return getCars().stream()
            .filter(car -> car.isWinner(getMaxPosition()))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return getCars().stream()
            .map(Car::getPosition)
            .mapToInt(String::length)
            .max()
            .getAsInt();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

}
