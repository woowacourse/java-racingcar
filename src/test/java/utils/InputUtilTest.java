package utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputUtilTest {
	@ParameterizedTest
	@MethodSource("generateInput")
	void 자동차입력_예외처리(String input, String expectedExceptionMessage) {
		assertThatThrownBy(() -> InputUtil.readCars(input))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(expectedExceptionMessage);
	}

	static Stream<Arguments> generateInput() {
		return Stream.of(Arguments.of("pobi, ,sika", "의 길이가 1~5 사이에 있지 않습니다."),
				Arguments.of("bumblebee,sika,pobi", "의 길이가 1~5 사이에 있지 않습니다."),
				Arguments.of("pobi,pobi,sika", "중복된 이름이 존재합니다."),
				Arguments.of("pobi", "자동차는 최소 2대 이상이어야 합니다."),
				Arguments.of(",,,", "의 길이가 1~5 사이에 있지 않습니다."));
	}
}
