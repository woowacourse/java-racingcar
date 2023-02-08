package racingcar.domain;

public class Car {
	private static final int NAME_MAX_LENGTH = 5;
	private static final int MOVE_MIN_NUMBER = 4;
	private String name;
	private int position;

	public Car(String name) {
		validateNameLength(name);
		this.name = name;
		this.position = 0;
	}

	private void validateNameLength(String name) {
		if (name.length() > NAME_MAX_LENGTH) {
			throw new IllegalArgumentException("[ERROR]: 자동차 이름은 5자 이하여야 합니다.");
		}
	}

	public void move(int number) {
		if (isMove(number)) {
			position ++;
		}
	}

	private boolean isMove(int number) {
		return number >= MOVE_MIN_NUMBER;
	}

	public int getPosition() {
		return position;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(this.name + " : -");
		for (int i = 0; i < position; i++) {
			sb.append("-");
		}
		return sb.toString();
	}
}
