package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarsFactoryTest {
	@ParameterizedTest
	@MethodSource("generateInput_중복")
	void 이름_중복(String input) {

		assertThatThrownBy(() -> CarsFactory.createCars(input))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("중복된 이름이 존재합니다.");
	}

	@ParameterizedTest
	@MethodSource("generateInput_최소_대수")
	void 최소_자동차_대수(String input) {
		assertThatThrownBy(() -> CarsFactory.createCars(input))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("자동차는 최소 2대 이상이어야 합니다.");
	}

	static Stream<Arguments> generateInput_중복() {
		return Stream.of(Arguments.of("bumbl, bumbl, sika"),
				Arguments.of("ff, ff, ff"));
	}

	static Stream<Arguments> generateInput_최소_대수() {
		return Stream.of(Arguments.of("aaa"),
				(Arguments.of("")));
	}
}
