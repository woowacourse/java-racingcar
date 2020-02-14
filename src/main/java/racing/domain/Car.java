package racing.domain;

public class Car {
	public static final int MAX_LENGTH = 5;
	public static final int MIN_LENGTH = 1;
	private static final int FORWARD_PIVOT = 4;

	private String name;
	private int position;

	public Car(String name) {
		this.name = name;
		this.position = 0;
	}

	public Car(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public void goForward(int number) {
		if (number >= FORWARD_PIVOT) {
			position++;
		}
	}

	public boolean isSamePosition(int position) {
		return this.position == position;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
