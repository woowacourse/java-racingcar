package racingcar.domain;

import racingcar.utils.Randoms;

public class RandomMovingPolicy implements MovingPolicy {

	public boolean isMove() {
		return Randoms.pickNumberInRange(0, 9) >= 4;
	}
}
