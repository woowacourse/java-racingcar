package racingcargame.domain.car;

import racingcargame.domain.MoveDecider;

public class Car {
	private CarName carName;
	private CarPosition carPosition;

	public Car(String name) {
		this.carName = new CarName(name);
		this.carPosition = new CarPosition();
	}

	public CarDto convertToCarDto() {
		return new CarDto(carName.getName(), carPosition.getPosition());
	}

	public void decideMoveOrStop(MoveDecider moveDecider) {
		if (moveDecider.isMovable()) {
			move();
		}
	}

	public int move() {
		return carPosition.increase();
	}
}
