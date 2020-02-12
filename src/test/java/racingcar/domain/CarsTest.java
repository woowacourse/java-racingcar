package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarsTest {
	@ParameterizedTest
	@MethodSource("generateInput_중복")
	void 이름_중복(List<String> input) {

		assertThatThrownBy(() -> new Cars(input))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("중복된 이름이 존재합니다.");
	}

	@ParameterizedTest
	@MethodSource("generateInput_최소_대수")
	void 소_자동차_대수(List<String> input) {
		assertThatThrownBy(() -> new Cars(input))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("자동차는 최소 2대 이상이어야 합니다.");
	}

	static Stream<Arguments> generateInput_중복() {
		return Stream.of(Arguments.of(Arrays.asList("bumbl","bumbl","sika")),
				Arguments.of(Arrays.asList("ff", "ff", "ff")));
	}

	static Stream<Arguments> generateInput_최소_대수() {
		return Stream.of(Arguments.of(Arrays.asList("aaa")),
				(Arguments.of(Arrays.asList(""))));
	}
}
