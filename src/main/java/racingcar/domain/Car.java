package racingcar.domain;

public class Car {
	private static final int MOVE_FORWARD = 4;
	private String name;
	private int position;

	public Car(String name) {
		this.name = name;
		position = 0;
	}

	public void move(int randomNumber) {
		if (shouldMove(randomNumber)) {
			position++;
		}
	}

	public boolean isWinner(int winnerPosition) {
		return winnerPosition == position;
	}

	private boolean shouldMove(int randomNumber) {
		return randomNumber >= MOVE_FORWARD;
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		StringBuilder trace = new StringBuilder();
		for (int i = 0; i < position; i++) {
			trace.append("-");
		}

		return name + ": " + trace.toString();
	}

}
