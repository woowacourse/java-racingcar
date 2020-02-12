package racingcar.domain;
/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * CarsTest.java
 * cars 객체 테스트
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {
	@DisplayName("이름목록과 라운드 횟수를 받아 Cars 생성실패 - 부적절한 라운드 횟수")
	@ParameterizedTest
	@ValueSource(ints = {0, -1})
	void testCar(int numberOfRound) {
		List<String> names = Arrays.asList("또링", "동글");
		assertThatThrownBy(() -> new Cars(names, numberOfRound))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("round number must be positive");
	}
}
