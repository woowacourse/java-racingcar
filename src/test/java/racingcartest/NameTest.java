package racingcartest;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.InputView;

public class NameTest {

	@ParameterizedTest
	@ValueSource(strings = {"", "abc,abc", "!@#,abc", "asdkqop,qwe", ",,,,"})
	public void nameExceptNullTest(String input) {
		assertThatThrownBy(() -> InputView.checkNameError(input)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
	}

	@Test
	public void nameNullTest() {
        assertThatThrownBy(() -> InputView.checkNameError(null)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }

}
