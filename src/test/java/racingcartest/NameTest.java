package racingcartest;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.util.Checker;

public class NameTest {
	Checker checker = new Checker();

	@ParameterizedTest
	@ValueSource(strings = {"", "abc,abc", "!@#,abc", "asdkqop,qwe", ",,,,"})
	public void nameExceptNullTest(String input) {
		assertThat(checker.checkNameConditions(input)).contains("[ERROR]");
	}

	@Test
	public void nameNullTest() {
		assertThat(checker.checkNameConditions(null)).contains("[ERROR]");
	}

}
