package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * RoundTest.java
 * 라운드 객체 테스트
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */
class RoundTest {
	private Round round;

	@BeforeEach
	void setUp() {
		round = new Round(4);
	}

	@DisplayName("부적절한 라운드 횟수 입력")
	@ParameterizedTest
	@ValueSource(ints = {0, -1})
	void testRound(int numberOfRound) {
		assertThatThrownBy(() -> new Round(numberOfRound))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("round number must be positive");
	}

	@DisplayName("마지막 라운드 아닌가 체크 - True")
	@Test
	void testisFinalRound_success() {
		int checkRound = 3;
		assertThat(round.isNonFinalRound(checkRound)).isTrue();
	}

	@DisplayName("마지막 라운드 맞는지 체크 - False")
	@Test
	void testisFinalRound_fail() {
		int checkRound = 4;
		assertThat(round.isNonFinalRound(checkRound)).isFalse();
	}
}