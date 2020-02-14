package racingcar.splitter;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.Car;
import racingcar.domain.Name;

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
public class CarSplitterTest {
	@DisplayName("쉼표를 기준으로 문자열을 정상적으로 분리")
	@Test
	void Should_success_When_appropriateValue() {
		assertThat(CarSplitter.split("네오,프로도,튜브"))
			.containsExactly(new Car(new Name("네오")), new Car(new Name("프로도")), new Car(new Name("튜브")));
	}

	@DisplayName("입력받은 이름 중 1~5자 사이가 아닌 글자 들어간 경우")
	@ParameterizedTest
	@ValueSource(strings = {"네오네오빔빔,검은고양이네로", "콘,검은고양이네로"})
	void Should_exception_When_inappropriateNameLength(String input) {
		assertThatThrownBy(() -> CarSplitter.split(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("name must be between 1-5");
	}
}
