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
	private final int maxPosition;

	public WinningRule(final List<Car> cars, final int maxPosition) {
		this.cars = Objects.requireNonNull(cars);
		this.maxPosition = maxPosition;
	}

	public List<Name> decideWinners() {
		return cars.stream()
				.filter(car -> car.isPositionOf(maxPosition))
				.map(Car::getName)
				.collect(Collectors.toList());
	}
}
