package racingcar.domain.game;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Position;

public class CarGenerator {
	private CarGenerator() {
	}

	public static Car from(final String name) {
		return new Car(new CarName(name), new Position());
	}
}
