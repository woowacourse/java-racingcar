package racingcargame.domain;

import racingcargame.genrator.RandomGenerator;
import sun.plugin2.applet.StopListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public Names getWinnerNames() {
        return findCarNamesInPosition(findMaxPosition());
    }

    private Position findMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Position::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("최대값을 뽑을 수 없습니다."));
    }

    private Names findCarNamesInPosition(int position) {
        return new Names(cars.stream()
                .filter(car -> car.isSamePosition(position))
                .map(Car::getName)
                .collect(Collectors.toList()));
    }

    private Names findCarNamesInPosition(Position position) {
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
