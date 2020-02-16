package racingcar.domain;

import java.util.List;

import racingcar.utils.NumberGenerator;

public class RacingGame {
	private final int gameCount;
	private final Cars cars;
	private int progressCount;

	public RacingGame(Cars cars, int gameCount) {
		this.cars = cars;
		this.gameCount = gameCount;
		this.progressCount = 0;
	}

	public void race(NumberGenerator numberGenerator) {
		for (Car car : cars.getCars()) {
			int randomValue = numberGenerator.getNumber();
			car.movePositionAccordingToCondition(randomValue);
		}
		this.progressCount++;
	}

	public boolean isEnd() {
		return this.progressCount == this.gameCount;
	}

	public List<Car> getCars() {
		return cars.getCars();
	}
}
