/*
 * PositionTest.java                        1.0.0   2020-02-15
 *
 * Copyright (c) 2020 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author HyungjuAn
 */
public class PositionTest {
	@ParameterizedTest
	@CsvSource(value = {"0 false", "3 false", "4 true", "9 true"}, delimiter = ' ')
	void 이동조건(int value, boolean expected) {
		Position position = new Position(value);
		assertThat(position.isMovable(value)).isEqualTo(expected);
	}

	@Test
	void 이동확인() {
		Position position = new Position(0);
		position.move();
		assertThat(position.getPosition()).isEqualTo(1);
	}
}
