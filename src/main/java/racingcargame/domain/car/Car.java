package racingcargame.domain.car;

import racingcargame.domain.MoveDecider;

public class Car implements Comparable<Car> {
	private CarName carName;
	private CarPosition carPosition;

	public Car(String name) {
		this.carName = new CarName(name);
		this.carPosition = new CarPosition();
	}

	public Car(Car car) {
		this.carName = new CarName(car.getCarName());
		this.carPosition = new CarPosition(car.getCarPosition());
	}

	public void decideGoOrStop(MoveDecider moveDecider) {
		if (moveDecider.isMovable()) {
			carPosition.increase();
			this.carPosition = new CarPosition(carPosition.getPosition());
		}
	}

	public boolean isMaxPosition(int position) {
		return this.carPosition.getPosition() == position;
	}

	public int getCarPosition() {
		return carPosition.getPosition();
	}

	public String getCarName() {
		return carName.getName();
	}

	@Override
	public int compareTo(Car c) {
		return c.carPosition.getPosition() - carPosition.getPosition();
	}
}
