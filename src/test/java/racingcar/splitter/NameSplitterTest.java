package racingcar.splitter;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * Splitter.java
 * 문자열 분리가 정상적으로 되었는지 테스트하는 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class NameSplitterTest {

	@DisplayName("쉼표를 기준으로 문자열을 정상적으로 분리")
	@Test
	void Should_success_When_appropriateValue() {
		Assertions.assertThat(NameSplitter.split("네오,프로도,튜브")).containsExactly("네오", "프로도", "튜브");
		Assertions.assertThat(NameSplitter.split("어피치,라이언,콘,무지,제이지")).containsExactly("어피치", "라이언", "콘", "무지", "제이지");
		Assertions.assertThat(NameSplitter.split("죠르디,프로도,튜브,123")).containsExactly("죠르디", "프로도", "튜브", "123");
	}

	@DisplayName("쉼표가 없거나, 이름이 하나일 있을 경우")
	@ParameterizedTest
	@EmptySource
	@ValueSource(strings = {"네오,", "네오"})
	void Should_exception_When_inappropriateValue(String input) {
		Assertions.assertThatThrownBy(() -> NameSplitter.split(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("car must be at least one");
	}

	@DisplayName("입력받은 이름 중 1~5자 사이가 아닌 글자 들어간 경우")
	@ParameterizedTest
	@ValueSource(strings = {"네오네오빔빔,검은고양이네로", "콘,검은고양이네로"})
	void Should_exception_When_inappropriateNameLength(String input) {
		Assertions.assertThatThrownBy(() -> NameSplitter.split(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("name must be between 1-5");
	}
}
