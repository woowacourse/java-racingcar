package racingcar;

public class Car {
	private String carName;
	private NumberGenerator numberGenerator;
	public Car(String carName, NumberGenerator numberGenerator) {
		this.carName = carName;
		this.numberGenerator = numberGenerator;
	}

	public boolean isMove() {
		if (numberGenerator.generate() >= 4) {
			return true;
		}
		return false;
	}
}
