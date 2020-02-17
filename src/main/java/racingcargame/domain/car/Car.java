package racingcargame.domain.car;

public class Car {
	private static final int MOVE_CONDITION = 4;

	private CarName carName;
	private CarPosition carPosition;

	public Car(String name) {
		this.carName = new CarName(name);
		this.carPosition = new CarPosition();
	}

	public CarDto convertToCarDto() {
		return new CarDto(carName.getName(), carPosition.getPosition());
	}

	public int decideMoveOrStop(int randomNo) {
		if (randomNo >= MOVE_CONDITION) {
			return carPosition.increase();
		}
		return carPosition.getPosition();
	}
}
