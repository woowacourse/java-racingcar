package racingcar.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 승리 결정 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/13
 */
public class WinningRule {
    private final List<Car> cars;

    public WinningRule(final List<Car> cars) {
        this.cars = Objects.requireNonNull(cars);
    }

    public List<Name> decideWinners() {
        int maxPosition = calculateMaxPosition();
        return cars.stream()
                .filter(car -> car.isPositionOf(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int calculateMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .map(Position::getPosition)
                .max(Integer::compare)
                .orElseThrow(IllegalArgumentException::new);
    }
}
