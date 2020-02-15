package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RaceCountTest {

	@ParameterizedTest
	@ValueSource(strings = {"a", ":", "-", "ㅁ"})
	void 레이스_횟수_정수(String raceCount) {
		assertThatThrownBy(() -> new RaceCount(raceCount))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("는 정수가 아닙니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "-2", "0"})
	void 레이스_횟수_자연수(String raceCount) {
		assertThatThrownBy(() -> new RaceCount(raceCount))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("는 자연수가 아닙니다.");
	}
}
