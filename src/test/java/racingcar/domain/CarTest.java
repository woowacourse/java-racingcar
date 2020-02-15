package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarTest {
	@Test
	void 이름이_널이_아닌지_확인() {
		assertThatThrownBy(() -> new Car(null))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("이름이 null일 수 없습니다.");
	}

	@ParameterizedTest
	@MethodSource("generateInput")
	void 이름_길이_1이상_5이하(String input) {
		assertThatThrownBy(() -> new Car(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("의 길이가 1~5 사이에 있지 않습니다.");
	}

	static Stream<Arguments> generateInput() {
		return Stream.of(Arguments.of("bumblebee,pobi,sika"),
			Arguments.of("ie,aaaaa,jjjj"));
	}
}
