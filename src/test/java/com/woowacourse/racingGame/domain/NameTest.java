package com.woowacourse.racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NameTest {
	@Test
	void checkNullOrEmpty_null_또는_빈_문자열() {
		final String nullName = null;

		assertThatThrownBy(() -> new Name(nullName))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("null 또는 빈 문자열입니다.");

		final String emptyName = "";

		assertThatThrownBy(() -> new Name(emptyName))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("null 또는 빈 문자열입니다.");
	}

	@Test
	void checkValidLength_자동차_이름의_길이가_5를_초과() {
		final String name = "abcdef";

		assertThatThrownBy(() -> new Name(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("이름은 5자이하만 가능합니다.");
	}
}
