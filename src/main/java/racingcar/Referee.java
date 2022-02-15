package racingcar;

public class Referee {
	private static final int MOVE_CRITERIA = 4;

	public static void moveCar(Car car, int randomValue) {
		if (randomValue >= MOVE_CRITERIA) {
			car.move();
		}
	}
}
