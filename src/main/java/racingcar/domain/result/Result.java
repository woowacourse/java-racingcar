package racingcar.domain.result;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Position;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private final List<Car> result;

    private Result(List<Car> result) {
        this.result = result;
    }

    public static Result of(List<Car> result) {
        return new Result(result);
    }

    public Position getMaxPosition() {
        Position maxPosition = Position.valueOf(0);
        for (Car car : result) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    public List<String> getWinners() {
        return result.stream()
                .filter(car -> car.isSamePosition(getMaxPosition()))
                .map(Car::getName)
                .map(CarName::getValue)
                .collect(Collectors.toList());
    }

    public List<Car> getResult() {
        return Collections.unmodifiableList(result);
    }
}
