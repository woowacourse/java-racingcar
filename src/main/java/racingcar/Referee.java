package racingcar;

public class Referee {
	private static final int MOVE_CRITERIA = 4;

	public static void judgeCarMove(Car car, int randomValue) {
		if (randomValue >= MOVE_CRITERIA) {
			car.move();
		}
	}
}
