package racingcar.service;

public class RandomNumberMovingCondition implements MovingCondition {
	public static final int MOVING_CONDITION_NUMBER = 4;

	@Override
	public boolean canMove() {
		int number = RandomNumberService.getRandomNumber();
		return number >= MOVING_CONDITION_NUMBER;
	}
}
