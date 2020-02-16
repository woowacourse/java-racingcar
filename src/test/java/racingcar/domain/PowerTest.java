package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * PowerTest.java
 * 동력 관련 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        15 Feb 2020
 *
 */
class PowerTest {
	@DisplayName("주어진 동력으로 이동 가능한지 테스")
	@ParameterizedTest
	@CsvSource(value = {"0,false", "3,false", "4,true", "9,true"})
	void movableTest(int powerLevel, boolean expected) {
		Power level = new Power(powerLevel);
		assertThat(level.isMovable()).isEqualTo(expected);
	}

	@DisplayName("유효범위 밖의 동력 주어진 경우 예외 던지는지 테스트")
	@ParameterizedTest
	@ValueSource(ints = {-1, 10})
	void nonMovableTestOverTheMaximumRangeException(int powerLevel) {
		assertThatThrownBy(() -> new Power(powerLevel))
			.isInstanceOf(IllegalArgumentException.class);
	}
}