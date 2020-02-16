package racingcargame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcargame.exception.CarNameInputException;

@SuppressWarnings("NonAsciiCharacters")
public class NameTest {

	@Test
	void null값이_들어왔을때() {
		assertThatThrownBy(() -> {
			new Name(null);
		}).isInstanceOf(CarNameInputException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"abcdef", "1234567"})
	void 자동차_이름의_길이가_5를_초과할때(String input) {
		assertThatThrownBy(() -> {
			new Name(input);
		}).isInstanceOf(CarNameInputException.class);
	}

	@Test
	void 자동차_이름이_공백일때() {
		assertThatThrownBy(() -> {
			new Name("");
		}).isInstanceOf(CarNameInputException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"brown:true", "broil:false"}, delimiter = ':')
	void 같은_이름인지_확인(String input, boolean expected) {
		Name name1 = new Name("brown");
		Name name2 = new Name(input);
		boolean result = name1.equals(name2);
		assertThat(result).isEqualTo(expected);
	}
}
