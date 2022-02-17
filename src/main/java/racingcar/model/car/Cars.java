package racingcar.model.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.dto.CarDto;
import racingcar.util.MovableStrategy;

public class Cars {
    private final List<Car> cars = new ArrayList<Car>();

    public Cars() {
    }

    public void add(Car car) {
        validateDuplicate(car);
        cars.add(car);
    }

    public void race(MovableStrategy movableStrategy) {
        for (Car car : cars) {
            car.move(movableStrategy);
        }
    }

    public List<String> getWinnersNames() {
        return getWinners().stream()
            .map(Car::toDto)
            .map(CarDto::getName)
            .collect(Collectors.toList());
    }

    private List<Car> getWinners() {
        return getCarsByPosition(getFirstPosition());
    }

    public List<Car> getCarsByPosition(Position position) {
        return cars.stream()
            .filter((car) -> car.getPosition().equals(position))
            .collect(Collectors.toList());
    }

    public Position getFirstPosition() {
        validateIsEmpty();
        Collections.sort(cars, Comparator.reverseOrder());
        return cars.get(0).getPosition();
    }

    public List<CarDto> getCarsDto() {
        return cars.stream()
            .map(Car::toDto)
            .collect(Collectors.toList());
    }

    public void validateIsEmpty() {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("아무 차량도 추가되지 않았습니다.");
        }
    }

    private void validateDuplicate(Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException("이미 존재하는 자동차 이름입니다.");
        }
    }
}
