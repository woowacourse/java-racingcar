package racingcar.model.car;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.value.Position;

public class Winners {
    private final List<String> names;

    public Winners(List<Car> cars) {
        Position maxPosition = getMaxPosition(cars);
        names = cars.stream()
                .filter(car -> car.isSameWith(maxPosition))
                .map(car -> car.getName().toString())
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getNames() {
        return names;
    }

    private Position getMaxPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Position::compareTo)
                .orElse(Position.fromStartLine());
    }
}
