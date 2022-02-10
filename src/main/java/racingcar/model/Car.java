package racingcar.model;

public class Car {
	private String name;
	private int position;

	public Car(String name) {
		validateName(name);
		this.name = name;
		this.position = 0;
	}

	public void go(int random) {
		if (random >= 4) {
			this.position++;
		}
	}

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}

	private void validateName(String name) {
		if (name == null || name.isBlank() || name.length() > 5) {
			throw new IllegalArgumentException("[ERROR] 올바르지 않은 이름 입력입니다.");
		}
	}

	@Override
	public String toString() {
		return name + " : " + getPositionString();
	}

	private String getPositionString() {
		return "-".repeat(Math.max(0, position));
	}
}
