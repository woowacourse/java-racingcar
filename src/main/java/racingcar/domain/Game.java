package racingcar.domain;

import java.util.Set;

public class Game {
	private final UniqueCars uniqueCars;

	public Game(UniqueCars uniqueCars) {
		this.uniqueCars = uniqueCars;
	}

	public UniqueCars play(MoveStrategy moveStrategy) {
		uniqueCars.getCars().stream()
			.filter(car -> moveStrategy.isMovable())
			.forEach(Car::move);
		return uniqueCars;
	}

	public Set<Car> getWinners() {
		return uniqueCars.getCarsInPosition(uniqueCars.getMaxPosition());
	}
}
