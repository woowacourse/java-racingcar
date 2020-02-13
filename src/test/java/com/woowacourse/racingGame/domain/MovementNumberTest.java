package com.woowacourse.racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MovementNumberTest {
	@Test
	void checkValid_이동_횟수가_숫자가_아닌_경우() {
		final String notMovementNumber = "abc";

		assertThatThrownBy(() -> new MovementNumber(notMovementNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("입력한 이동 횟수가 숫자가 아닙니다.");
	}

	@Test
	void checkPositive_이동_횟수가_음수() {
		final String invalidMovementNumber = "-1";

		assertThatThrownBy(() -> new MovementNumber(invalidMovementNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
