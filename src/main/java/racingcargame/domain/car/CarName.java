package racingcargame.domain.car;

class CarName {
	private static final int ZERO = 0;
	private static final int NAME_UPPER_LIMIT = 5;
	private static final String BLANK = " ";

	private String name;

	CarName(String name) {
		validateNull(name);
		validateLength(name);
		validateBlank(name);
		this.name = name;
	}

	private void validateLength(String name) {
		if (name.length() <= ZERO || name.length() > NAME_UPPER_LIMIT) {
			throw new IllegalArgumentException("이름은 1자 이상 5자 이하로 해주세요.");
		}
	}

	private void validateNull(String name) {
		if (name == null) {
			throw new IllegalArgumentException("이름은 null값이 될 수 없습니다.");
		}
	}

	private void validateBlank(String name) {
		if (name.contains(BLANK)) {
			throw new IllegalArgumentException("이름에는 띄어쓰기가 포함될 수 없습니다.");
		}
	}

	String getName() {
		return name;
	}
}
