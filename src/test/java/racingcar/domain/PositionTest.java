package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * PositionTest.java
 * 자동차 위치 관련 테스트 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        14 Feb 2020
 *
 */
class PositionTest {
	@DisplayName("포지션 예외 테스트")
	@Test
	void invalid_position_test() {
		assertThatThrownBy(() -> Position.ofValue(-1))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("포지션 이동 테스트")
	@Test
	void valid_position_test() {
		Position position = Position.ofValue(0);
		Position newPosition = position.moveForward();
		assertThat(newPosition).extracting("position").isEqualTo(1);
	}

	@DisplayName("두 포지션 간 위치 비교 테스트")
	@Test
	void compare_each_position_test() {
		Position positionFirst = Position.ofValue(10);
		Position positionSecond = Position.ofValue(5);
		assertThat(positionFirst.isGreaterThanOrEqualTo(positionSecond)).isTrue();
	}
}