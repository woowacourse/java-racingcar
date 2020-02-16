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
 * RoundTest.java
 * 라운드 객체 테스트
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */
class RoundTest {
	@DisplayName("부적절한 라운드 횟수 입력시 예외 발생 테스트")
	@ParameterizedTest
	@ValueSource(ints = {0, -1})
	void testRound(int numberOfRound) {
		assertThatThrownBy(() -> new Round(numberOfRound))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("round number must be positive");
	}

	@DisplayName("현재 라운드가 마지막 라운드가 아닌지 체크 하는 테스트")
	@ParameterizedTest
	@CsvSource({"3,true", "4,false"})
	void isNonFinalRound_test(int currentRound, boolean expected) {
		Round round = new Round(4);
		assertThat(round.nonFinalRound(currentRound)).isEqualTo(expected);
	}
}