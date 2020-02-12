package com.woowacourse.racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PositionTest {
	@Test
	void checkValidation_위치가_음수() {
		final int invalidValue = -1;

		assertThatThrownBy(() -> new Position(invalidValue))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
