package domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("시도 횟수는")
class TrialTest {

	@DisplayName("정수값만 입력 가능하다.")
	@ParameterizedTest
	@ValueSource(strings = {"문자", "char", "@#"})
	void checkOnlyInteger(String input) {
		assertThatThrownBy(() -> new Trial(Integer.parseInt(input))).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("시도 횟수가 0일 경우 테스트")
	@Test
	void checkZero() {
		assertThatThrownBy(() -> new Trial(0)).isInstanceOf(IllegalArgumentException.class);
	}
}
