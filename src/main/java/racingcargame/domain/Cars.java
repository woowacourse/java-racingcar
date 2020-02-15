package racingcargame.domain;

import racingcargame.genrator.RandomGenerator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getCarNamesInMaxPosition() {
        return getCarNamesInSamePositionWith(getMaxPosition());
    }

    private Position getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Position::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("최대값을 뽑을 수 없습니다."));
    }

    private List<String> getCarNamesInSamePositionWith(int position) {
        return cars.stream()
                .filter(car -> car.isSamePositionWith(position))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<String> getCarNamesInSamePositionWith(Position position) {
        return getCarNamesInSamePositionWith(position.getPosition());
    }

    public void moveOneRound() {
        for (Car car : cars) {
            car.move(RandomGenerator.generateRandom());
        }
    }
}
