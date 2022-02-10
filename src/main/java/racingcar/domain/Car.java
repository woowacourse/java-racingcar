package racingcar.domain;

public class Car {
	private static final int PROCEED_FlAG_NUMBER = 4;

	private final String name;
	private int position;

	public Car(String name) {
		this.name = name;
		this.position = 0;
	}

	public void proceed(int randomNumber) {
		if (randomNumber >= PROCEED_FlAG_NUMBER) {
			this.position++;
		}
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public boolean isWinner(int maxPosition) {
		return this.position == maxPosition;
	}
}
