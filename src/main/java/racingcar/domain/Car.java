package racingcar.domain;

public class Car {
	public static final int StartPosition = 0;
	private final String name;
	private int position;

	public Car(String name) {
		this.name = name;
		position = StartPosition;
	}

	public void move(RandomNo RandomNo) {
		if (RandomNo.isMove()) {
			position++;
		}
	}

	public boolean isWinner(int winnerPosition) {
		return winnerPosition == position;
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
		for (int i = StartPosition; i < position; i++) {
			trace.append("-");
		}

		return name + ": " + trace.toString();
	}

}
