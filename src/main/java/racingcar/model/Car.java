package racingcar.model;

public class Car {
	private String name;
	private int position;

	public Car(String name) {
		validateName(name);
		this.name = name;
		this.position = 0;
	}

	private void validateName(String name) {
		if (name == null || name.isBlank() || name.length() > 5) {
			throw new IllegalArgumentException("[ERROR] 올바르지 않은 이름 입력입니다.");
		}
	}
}
