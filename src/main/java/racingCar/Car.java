package racingCar;

public class Car {
	private final String name;
	int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void moveCar(boolean isGoing) {
		if (isGoing) {
			this.position++;
		}
	}

	@Override
	public String toString() {
		String output = name + " : ";
		for (int idx = 0; idx < position; idx++) {
			output += "-";
		}
		return output;
	}

	public int getPosition() {
		return this.position;
	}

	public void printName() {
		System.out.print(this.name);
	}


}
