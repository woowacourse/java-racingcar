package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RaceTest {
	@ParameterizedTest
	@ValueSource(strings = {"a", ":", "-", "ㅁ"})
	void 레이스_횟수_정수(String raceCount) {
		Cars cars = new Cars(Arrays.asList("aa", "bb", "cc"));
		assertThatThrownBy(() -> new Race(cars, raceCount))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("는 정수가 아닙니다.");
	}
}
