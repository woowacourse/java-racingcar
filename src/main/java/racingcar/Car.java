package racingcar;

public class Car implements Comparable<Car> {
	private String carName;
	private int position;
	private NumberGenerator numberGenerator;

	public Car(String carName, NumberGenerator numberGenerator) {
		this.carName = carName;
		this.position = 0;
		this.numberGenerator = numberGenerator;
	}

	public void tryDrive() {
		if (isMove()) {
			position++;
		}
	}

	public boolean isMove() {
		if (numberGenerator.generate() >= 4) {
			return true;
		}
		return false;
	}

	public String getCarName() {
		return this.carName;
	}

	@Override
	public int compareTo(Car other) {
		return other.position - this.position;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(carName).append(" : ");
		for (int i = 0 ; i < this.position ; i++) {
			stringBuilder.append("-");
		}
		return stringBuilder.toString();
	}
}
