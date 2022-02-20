package racingcar.domain;

public class Car implements Comparable<Car> {

	private static final int INITIAL_POSITION = 0;
	private static final int STANDARD_OF_MOVING = 4;
	private static final int NAME_LENGTH_LIMIT = 5;
	private static final int MINIMUM_POSITION = 0;
	private static final String INVALID_CAR_NAME_ERROR_MESSAGE = "자동차의 이름은 1~5글자여야 합니다.";
	private static final String INVALID_POSITION_ERROR_MESSAGE = "자동차 위치는 0 이상이여야 합니다.";

	private final String name;
	private int position;

	private Car(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public static Car of(String name) {
		checkNameLength(name);

		return new Car(name, INITIAL_POSITION);
	}

	public static Car of(String name, int position) {
		checkNameLength(name);
		checkPositionRange(position);

		return new Car(name, position);
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	public Car copy() {
		return Car.of(this.name, this.position);
	}
	public static void checkNameLength(String name) {
		if (name.isEmpty() || isOverLength(name)) {
			throw new IllegalArgumentException(INVALID_CAR_NAME_ERROR_MESSAGE);
		}
	}

	private static boolean isOverLength(String name) {
		return name.length() > NAME_LENGTH_LIMIT;
	}

	public static void checkPositionRange(int position) {
		if(position < MINIMUM_POSITION) {
			throw new IllegalArgumentException(INVALID_POSITION_ERROR_MESSAGE);
		}
	}

	public void move(int movingValue) {
		if (movingValue >= STANDARD_OF_MOVING) {
			this.position++;
		}
	}

	public boolean isSamePosition(Car other) {
		return this.position == other.position;
	}

	public boolean isSamePosition(int position) {
		return this.position == position;
	}

	@Override
	public int compareTo(Car other) {
		return this.position - other.position;
	}
}
