package racingcargame.domain;

public class Engine {
	private static final int MIN_GO_POWER = 4;
	private static final int MAX_NUMBER = 10;

	private int power;

	private Engine(int power) {
		this.power = power;
	}

	public static Engine create() {
		int power = (int)(Math.random() * MAX_NUMBER);
		return new Engine(power);
	}

	public static Engine createBy(int power) {
		return new Engine(power);
	}

	public boolean canMove() {
		return MIN_GO_POWER <= power;
	}
}