package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputViewTest {

	@Test
	void 시도_횟수_입력_검증() {
		Assertions.assertThatThrownBy(() -> {
				InputView.validPositiveInput("-1");
			}).isInstanceOf(RuntimeException.class)
			.hasMessageContaining("양수");
	}

	@Test
	void 시도_횟수_빈_입력_검증() {
		Assertions.assertThatThrownBy(() -> {
				String input = "";
				InputView.validEmptyInput(input);
			}).isInstanceOf(RuntimeException.class)
			.hasMessageContaining("빈 값");
	}

	@Test
	void 시도_횟수_0_입력_검증() {
		Assertions.assertThatThrownBy(() -> {
				String input = "0";
				InputView.validNonZeroInput(input);
			}).isInstanceOf(RuntimeException.class)
			.hasMessageContaining("0");
	}
}
