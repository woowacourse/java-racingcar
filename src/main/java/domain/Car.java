package domain;

import domain.strategy.MovingStrategy;

public class Car {
	private final CarName carName;
	private final CarLocation carLocation;
	private final MovingStrategy movingStrategy;

	public Car(String name, int location, MovingStrategy movingStrategy) {
		this.carName = new CarName(name);
		this.carLocation = new CarLocation(location);
		this.movingStrategy = movingStrategy;
	}

	public void move() {
		if (movingStrategy.canMove()) {
			carLocation.increase();
		}
	}

	public String getCarName() {
		return carName.getName();
	}

	public int getCarLocation() {
		return carLocation.getLocation();
	}
}
