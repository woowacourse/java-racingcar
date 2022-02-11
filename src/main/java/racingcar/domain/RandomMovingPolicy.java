package racingcar.domain;

import racingcar.utils.Randoms;

public class RandomMovingPolicy implements MovingPolicy {
	private static final int START_INCLUSIVE = 0;
	private static final int END_INCLUSIVE = 9;
	private static final int CONDITION_FOR_MOVE = 4;

	public boolean isMove() {
		return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE)
			>= CONDITION_FOR_MOVE;
	}
}
