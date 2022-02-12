package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
	@ParameterizedTest
	@ValueSource(strings = {"0", "-1"})
	void 시도_횟수_입력_검증(String input) {
		Assertions.assertThatThrownBy(() -> {
				InputValidator.validIterationNo(input);
			}).isInstanceOf(RuntimeException.class)
			.hasMessageContaining("양수");
	}

	@Test
	void 시도_횟수_빈_입력_검증() {
		Assertions.assertThatThrownBy(() -> {
				InputValidator.validIterationNo("");
			}).isInstanceOf(RuntimeException.class)
			.hasMessageContaining("빈 값");
	}
}