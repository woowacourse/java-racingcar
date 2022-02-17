package racingcartest;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.InputView;

public class InputViewTest {

	@ParameterizedTest
	@ValueSource(strings = {"", "abc,abc", "!@#,abc", "asdkqop,qwe", ",,,,"})
	public void nameExceptNullTest(String input) {
		assertThatThrownBy(() -> InputView.checkNameError(input)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@Test
	public void nameNullTest() {
		assertThatThrownBy(() -> InputView.checkNameError(null)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "ab", "-100"})
	public void turnTest(String input) {
		assertThatThrownBy(() -> InputView.checkTurnError(input)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@Test
	public void turnNullTest() {
		assertThatThrownBy(() -> InputView.checkTurnError(null)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}
}
