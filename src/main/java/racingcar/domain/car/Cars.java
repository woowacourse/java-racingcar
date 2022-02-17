package racingcar.domain.car;

import racingcar.util.RandomGeneratable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int DEFAULT_POSITION = 0;
    private static final int RANDOM_MIN_BOUND = 0;
    private static final int RANDOM_MAX_BOUND = 9;
    private static final String TO_STRING_DELIMITER = "\n";
    private static final String NAME_DELIMITER = ",";
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<Name> names) {
        List<Car> cars = names.stream()
                .map((name) -> Car.of(name.toString(), DEFAULT_POSITION))
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    public static Cars create() {
        return new Cars(new ArrayList<>());
    }

    public void add(Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException("이미 존재하는 자동차 이름입니다.");
        }

        cars.add(car);
    }

    public void moveAll(RandomGeneratable randomGeneratable) {
        cars.forEach((car) -> car.move(
                randomGeneratable.generateNumber(RANDOM_MIN_BOUND, RANDOM_MAX_BOUND))
        );
    }

    public List<Name> getWinnersNames() {
        return getCarsByPosition(getFirstPosition()).stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining(TO_STRING_DELIMITER));
    }

    private Position getFirstPosition() {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("아무 차량도 추가되지 않았습니다.");
        }
        Collections.sort(cars);
        return cars.get(0).getPosition();
    }

    private List<Car> getCarsByPosition(Position position) {
        return cars.stream()
                .filter((car) -> car.getPosition().equals(position))
                .collect(Collectors.toList());
    }

}
