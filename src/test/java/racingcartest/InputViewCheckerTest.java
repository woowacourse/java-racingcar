package racingcartest;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.InputViewChecker;

public class InputViewCheckerTest {

	@ParameterizedTest
	@ValueSource(strings = {"", "abc,abc", "!@#,abc", "asdkqop,qwe", ",,,,"})
	public void nameExceptNullTest(String input) {
		assertThatThrownBy(() -> InputViewChecker.checkNameInput(input)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@Test
	public void nameNullTest() {
		assertThatThrownBy(() -> InputViewChecker.checkNameInput(null)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "ab", "-100"})
	public void turnTest(String input) {
		assertThatThrownBy(() -> InputViewChecker.checkTurnInput(input)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@Test
	public void turnNullTest() {
		assertThatThrownBy(() -> InputViewChecker.checkTurnInput(null)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}
}
