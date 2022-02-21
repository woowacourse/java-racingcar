package racingcar.model.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.util.MovableStrategy;

public class Cars {
    private static final String DELIMITER = ",";

    private final List<Car> cars = new ArrayList<Car>();

    public Cars() {
    }

    public void addAllFromNamesSeparatedComma(String namesSeparatedComma) {
        String[] names = namesSeparatedComma.split(DELIMITER);
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void add(final Car car) {
        validateDuplicate(car);
        cars.add(car);
    }

    public void race(final MovableStrategy movableStrategy) {
        validateIsEmpty();
        for (Car car : cars) {
            car.move(movableStrategy);
        }
    }

    public List<String> getWinnersNames() {
        return getWinners().stream()
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private List<Car> getWinners() {
        return getCarsByPosition(getFirstPosition());
    }

    private List<Car> getCarsByPosition(final Position position) {
        return cars.stream()
            .filter((car) -> car.isInPosition(position))
            .collect(Collectors.toList());
    }

    private Position getFirstPosition() {
        validateIsEmpty();
        Collections.sort(cars, Comparator.reverseOrder());
        return new Position(cars.get(0).getPosition());
    }

    private void validateIsEmpty() {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("아무 차량도 추가되지 않았습니다.");
        }
    }

    private void validateDuplicate(final Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException("이미 존재하는 자동차 이름입니다.");
        }
    }
}
