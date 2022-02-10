package racingCar;

public class Car {
	String name;
	int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void moveCar(boolean isGoing) {
		if (isGoing) {
			this.position++;
		}
	}

}
