package racingcargame.domain;

import racingcargame.genrator.RandomGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getWinners() {
        return findCarNamesInPosition(findMaxPosition());
    }

    private Position findMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Position::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("최대값을 뽑을 수 없습니다."));
    }

    private List<String> findCarNamesInPosition(int position) {
        return cars.stream()
                .filter(car -> car.isSamePosition(position))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<String> findCarNamesInPosition(Position position) {
        return findCarNamesInPosition(position.getPosition());
    }

    public void moveOneRound() {
        for (Car car : cars) {
            car.move(RandomGenerator.generateRandom());
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
