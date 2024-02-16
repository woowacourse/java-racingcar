public class Car {

	private static final int MIN_NUMBER_FOR_MOVE = 4;

	private final CarName carName;
	private final CarLocation carLocation;

	private Car(CarName carName, CarLocation carLocation) {
		this.carName = carName;
		this.carLocation = carLocation;
	}

	public static Car from(String name, int location) {
		return new Car(
			new CarName(name),
			new CarLocation(location)
		);
	}

	public static Car from(String name) {
		return new Car(
			new CarName(name),
			new CarLocation(0)
		);
	}

	public void move(int randomNumber) {
		if (randomNumber >= MIN_NUMBER_FOR_MOVE) {
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
