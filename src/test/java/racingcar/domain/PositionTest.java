package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * ***.java
 * 000 담당하는 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        14 Feb 2020
 *
 */
class PositionTest {
	@Test
	void 포지션_예외_테스트() {
		assertThatThrownBy(() -> new Position(-1))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 포지션_Move_테스트() {
		Position position = new Position(0);
		position.moveForward();
		assertThat(position).extracting("position").isEqualTo(1);
	}

	@Test
	void 두포지션_비교_테스트() {
		Position positionFirst = new Position(10);
		Position positionSecond = new Position(5);
		assertThat(positionFirst.isGreaterThanOrEqualTo(positionSecond)).isTrue();
	}
}