package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * RacingGameTest.java
 * 레이싱게임의 기능을 테스트 하는 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */
class RacingGameTest {
	@DisplayName("Cars와 라운드 횟수를 받아 RacingGame 생성실패 - 부적절한 라운드 횟수")
	@ParameterizedTest
	@ValueSource(ints = {0, -1})
	void testRacingGame(int numberOfRound) {
		List<String> names = Arrays.asList("또링", "동글");
		Cars cars = new Cars(names);

		assertThatThrownBy(() -> new RacingGame(cars, numberOfRound))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("round number must be positive");
	}
}