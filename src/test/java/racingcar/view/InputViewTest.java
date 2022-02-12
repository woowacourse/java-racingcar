package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

	@ParameterizedTest
	@ValueSource(strings = {"0", "-1"})
	@DisplayName("시도 횟수 입력 양수 검증 테스트")
	void validPositiveInputTest(String input) {
		Assertions.assertThatThrownBy(() -> {
				InputView.validPositiveInput(input);
			}).isInstanceOf(RuntimeException.class)
			.hasMessageContaining("양수");
	}

	@Test
	@DisplayName("시도 횟수 빈 입력 검증 테스트")
	void validEmptyInputTest() {
		Assertions.assertThatThrownBy(() -> {
				InputView.validEmptyInput("");
			}).isInstanceOf(RuntimeException.class)
			.hasMessageContaining("빈 값");
	}
}
