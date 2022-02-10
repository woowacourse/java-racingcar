package racingcar;

public class Car {
	private static final int MAX_CAR_NAME_LENGTH = 5;
	private static final int INITIAL_POSITION = 0;
	private final String name;
	private int position;

	public Car(String name) {
		validName(name);
		this.name = name;
		this.position = INITIAL_POSITION;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return this.position;
	}

	private void validName(String name) {
		if (isOverNameLength(name)) {
			throw new RuntimeException("자동차 이름이 5글자를 초과했습니다. 5글자 이하로 입력해주세요.");
		}
		if (isEmptyName(name)) {
			throw new RuntimeException("자동차 이름에 빈 문자열이 입력됐습니다.");
		}
	}

	private boolean isOverNameLength(String name) {
			return name.length() > MAX_CAR_NAME_LENGTH;
	}

	private boolean isEmptyName(String name) {
		return name.isEmpty();
	}
}
