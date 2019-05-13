package racinggame;

public class Car {
	private final String name;
	private int position;

	private static final int MOVE_BOUND = 4;
	private static final int NAME_LENGTH_MAX = 5;
	private static final int NAME_LENGTH_MIN = 1;
	private static final String NAME_LENGTH_OUT_OF_BOUNDS_EXCEPTION_MESSAGE = "1 ~ 5자의 이름을 입력해주세요.";

	public Car(String name) {
		this(name, 0);
	}

	public Car(String name, int position) {
		if (!checkCarNameLength(name)) {
			throw new IllegalArgumentException(NAME_LENGTH_OUT_OF_BOUNDS_EXCEPTION_MESSAGE);
		}
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}

	public boolean matchPosition(int position) {
		return this.position == position;
	}

	public void move(int randomNumber) {
		if (randomNumber >= MOVE_BOUND) {
			this.position++;
		}
	}

	public boolean checkCarNameLength(String carName) {
		return carName.length() >= NAME_LENGTH_MIN && carName.length() <= NAME_LENGTH_MAX;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + position;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (position != other.position)
			return false;
		return true;
	}
}
