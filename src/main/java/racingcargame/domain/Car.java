package racingcargame.domain;

public class Car implements Comparable<Car> {

	private static final int GO_CONDITION = 4;

	private CarName carName;
	private CarPosition carPosition;

	public Car(String name) {
		this.carName = new CarName(name);
		this.carPosition = new CarPosition();
	}

	Car(Car car) {
		this.carName = new CarName(car.getCarName());
		this.carPosition = new CarPosition(car.getCarPosition());
	}

	public void decideGoOrStop(MoveDecider moveDecider) {
		if (moveDecider.getNumber() >= GO_CONDITION) {
			carPosition.increase();
			this.carPosition = new CarPosition(carPosition.getPosition());
		}
	}

	boolean isMaxPosition(int position) {
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
