package racingcartest;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.InputProcessView;

public class InputProcessViewTest {

	@ParameterizedTest
	@ValueSource(strings = {"", "abc,abc", "!@#,abc", "asdkqop,qwe", ",,,,"})
	public void nameExceptNullTest(String input) {
		assertThatThrownBy(() -> InputProcessView.getCarNameInput(input)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@Test
	public void nameNullTest() {
		assertThatThrownBy(() -> InputProcessView.getCarNameInput(null)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "ab", "-100"})
	public void turnTest(String input) {
		assertThatThrownBy(() -> InputProcessView.getTurnInput(input)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@Test
	public void turnNullTest() {
		assertThatThrownBy(() -> InputProcessView.getTurnInput(null)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}
}
