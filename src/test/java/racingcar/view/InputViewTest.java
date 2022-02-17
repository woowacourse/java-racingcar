package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

	@ParameterizedTest
	@ValueSource(strings = {"0", "-1"})
	@DisplayName("시도 횟수 양수 입력시 예외 발생")
	void validatePositiveInputTest(String input) {
		Assertions.assertThatThrownBy(() -> {
				InputView.validateIterationNumber(input);
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("양수");
	}

	@Test
	@DisplayName("시도 횟수 빈 입력 입력시 예외 발생")
	void validateEmptyInputTest() {
		Assertions.assertThatThrownBy(() -> {
				InputView.validateIterationNumber("");
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("빈 값");
	}
}
