package racingcar.model.car;

import racingcar.model.trycount.TryCount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String TO_STRING_DELIMITER = "\n";

    private final List<Car> cars = new ArrayList<>();

    private Cars() {

    }

    public static Cars create() {
        return new Cars();
    }

    public void add(Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException("이미 존재하는 자동차 이름입니다.");
        }

        cars.add(car);
    }

    public void moveAll(TryCount tryCount) {
        for (int i = 0; i < tryCount.toInt(); i++) {
            cars.forEach(Car::move);
        }
    }

    public Position getFirstPosition() {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("아무 차량도 추가되지 않았습니다.");
        }
        Collections.sort(cars);
        return cars.get(0).getPosition();
    }

    public List<Car> getCarsByPosition(Position position) {
        return cars.stream()
                .filter((car) -> car.getPosition().equals(position))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining(TO_STRING_DELIMITER));
    }

}
