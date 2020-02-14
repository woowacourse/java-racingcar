package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * NameTest.java
 * 이름 객체 테스 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        14 Feb 2020
 *
 */
class NameTest {
	@DisplayName("null 혹은 blank로 이름 객체 생성시 실패한다.")
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"   "})
	void try_to_construct_nameObject_with_null_or_blank_test(String name) {
		assertThatThrownBy(() -> new Name(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("name can not be null or blank");
	}

	@DisplayName("이름 글자 제한 초과시 객체 생성 실패한다.")
	@ParameterizedTest
	@ValueSource(strings = {"김수한무거북이와두루미"})
	void try_to_construct_nameObject_with_more_than_maximum_name_length_test(String name) {
		assertThatThrownBy(() -> new Name(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("name must be between 1-5");
	}
}