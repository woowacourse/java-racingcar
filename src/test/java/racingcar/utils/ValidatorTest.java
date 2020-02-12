package racingcar.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
	@ParameterizedTest
	@ValueSource(strings = {"pobi", "crong"})
	void ReturnTrue_When_ValidLengthOfName(String name) {
		boolean result = Validator.isValidLengthOfName(name);
		assertTrue(result);
	}

	@ParameterizedTest
	@ValueSource(strings = {"pobiconan", "subway"})
	void ReturnFalse_When_NotValidLengthOfName(String name) {
		boolean result = Validator.isValidLengthOfName(name);
		assertFalse(result);
	}

	@Test
	void ReturnTrue_When_DuplicatedName() {
		String[] names = {"pobi","pobi"};

		boolean result = Validator.containDuplicatedName(names);
		assertTrue(result);
	}
}
