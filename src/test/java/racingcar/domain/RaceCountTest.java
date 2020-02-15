package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
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

	@Test
	void 레이스_끝() {
		RaceCount raceCount = new RaceCount("1");

		assertThat(raceCount.isEnd()).isFalse();

		raceCount.increaseCurrentCount();
		assertThat(raceCount.isEnd()).isTrue();
	}
}
