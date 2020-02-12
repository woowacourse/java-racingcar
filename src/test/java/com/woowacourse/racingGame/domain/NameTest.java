package com.woowacourse.racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NameTest {
	@Test
	void checkValidLength_자동차_이름의_길이가_5를_초과() {
		final String name = "abcdef";

		assertThatThrownBy(() -> new Name(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("이름은 5자이하만 가능합니다.");
	}
}
