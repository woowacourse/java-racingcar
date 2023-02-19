package domain;

import static domain.CarFactory.*;

import domain.strategy.MovingStrategy;
import domain.strategy.RandomMovingStrategy;

public class RacingGame {
	Cars cars;
	MovingStrategy strategy;

	public RacingGame(String carNames) {
		cars = new Cars(arrangeCars(carNames));
		this.strategy = new RandomMovingStrategy(new RandomNumberGenerator());
	}

	public Cars moveCars() {
		cars.moveCars(strategy);
		return cars;
	}

	public Cars getCars() {
		return cars;
	}
}
