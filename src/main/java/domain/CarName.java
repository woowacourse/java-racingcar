package domain;

public class CarName {

	private static final int MAX_LENGTH = 5;

	private String name;

	public CarName(String name) {
		if (isRightLength(name)) {
			this.name = name;
		}
	}

	public String getName() {
		return name;
	}

	private boolean isRightLength(String name) {
		if (name == null || name.length() > MAX_LENGTH) {
			throw new IllegalArgumentException();
		}
		return true;
	}
}
