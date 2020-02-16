package racing.domain;

public class Car {
	private static final int FORWARD_PIVOT = 4;

	private final String name;
	private int position;

	public Car(final String name) {
		this.name = name;
		this.position = 0;
	}

	public Car(final String name, int position) {
		this.name = name;
		this.position = position;
	}

	public void goForward(int number) {
		if (number >= FORWARD_PIVOT) {
			position++;
		}
	}

	public boolean isWinnerPosition(int winnersPosition) {
		return this.position == winnersPosition;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
