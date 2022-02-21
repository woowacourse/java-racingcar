package racingcar.domain;

public class Car implements Comparable<Car> {
	private static final int DEFAULT_POSITION = 0;
	private static final int CAR_LENGTH_LIMIT = 5;

	private final String name;
	private int position;

	public Car(final String name) {
		this(name, DEFAULT_POSITION);
	}

	public Car(final String name, final int position) {
		checkValidName(name);
		checkValidPosition(position);
		this.name = name;
		this.position = position;
	}

	public void drive(final Movable movable) {
		if (movable.isMoving()) {
			move();
		}
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public boolean isSamePosition(final Car other) {
		return this.position == other.position;
	}

	@Override
	public int compareTo(final Car car) {
		return this.position - car.position;
	}

	@Override
	public String toString() {
		return "name : " + name + ", position : " + position;
	}

	private void checkValidName(final String names) {
		checkBlank(names);
		checkNameLength(names);
	}

	private void checkBlank(final String name) {
		String text = "자동차 이름은 %s일 수 없습니다.";
		if (name == null) {
			throw new NullPointerException(String.format(text, "null"));
		}
		if (name.trim().equals("")) {
			throw new IllegalArgumentException(String.format(text, "공백"));
		}
	}

	private void checkNameLength(final String name) {
		if (!(name.trim().length() <= CAR_LENGTH_LIMIT)) {
			throw new IllegalArgumentException("자동차의 이름은 " + CAR_LENGTH_LIMIT + "글자를 초과할 수 없습니다.");
		}
	}

	private void checkValidPosition(final int position) {
		if (position < 0) {
			throw new IllegalArgumentException("자동차 위치는 자연수를 입력해주세요.");
		}
	}

	private void move() {
		position++;
	}
}
