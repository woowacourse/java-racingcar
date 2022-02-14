package racingcar.model.vo;

import racingcar.model.RandomUtil;

public class RacingCarMovableStrategy implements MovableStrategy {
	private static final int RANGE_OF_ZERO_TO_NINE = 10;
	private static final int MOVABLE_STANDARD = 4;

	@Override
	public boolean isMove() {
		return RandomUtil.getNumbersInRange(RANGE_OF_ZERO_TO_NINE) >= MOVABLE_STANDARD;
	}
}
