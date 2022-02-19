package racingcar.domain;

public class Car implements Comparable<Car> {
	private static final int MOVE_FLAG = 3;
	private static final int CAR_LENGTH_LIMIT = 5;

	private final String name;
	private int position = 0;

	public Car(String name) {
		checkValidName(name);
		this.name = name;
	}

	public Car(String name, int position) {
		this(name);

		checkValidPosition(position);
		this.position = position;
	}

	public void drive(Movable movable) {
		if (movable.randomNumber() > MOVE_FLAG) {
			move();
		}
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public boolean isSamePosition(Car other) {
		return this.position == other.position;
	}

	@Override
	public int compareTo(Car car) {
		return this.position - car.position;
	}

	@Override
	public String toString() {
		return "name : " + name + ", position : " + position;
	}

	private void checkValidName(String names) {
		checkBlank(names);
		checkNameLength(names);
	}

	private void checkBlank(String name) {
		String text = "자동차 이름은 %s일 수 없습니다.";
		if (name == null) {
			throw new NullPointerException(String.format(text, "null"));
		}
		if (name.trim().equals("")) {
			throw new IllegalArgumentException(String.format(text, "공백"));
		}
	}

	private void checkNameLength(String name) {
		if (!(name.trim().length() <= CAR_LENGTH_LIMIT)) {
			throw new IllegalArgumentException("자동차의 이름은 " + CAR_LENGTH_LIMIT + "글자를 초과할 수 없습니다.");
		}
	}

	private void checkValidPosition(int position) {
		if (position < 0) {
			throw new IllegalArgumentException("자동차 위치는 자연수를 입력해주세요.");
		}
	}

	private void move() {
		position++;
	}
}
