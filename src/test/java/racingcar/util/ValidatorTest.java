package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {
	@ParameterizedTest
	@ValueSource(strings = {"withoutcomma", "", " "})
	void invalidStringInput(String input) {
		assertThat(Validator.validateNamesInput(input)).isFalse();
	}

	@Test
	void nullInput() {
		assertThat(Validator.validateNamesInput(null)).isFalse();
	}

	@ParameterizedTest
	@CsvSource(value = {"3,true", "0,false", "-3,false,100,true", "asdf,false", ",false"})
	void lap(String input, boolean expected) {
		assertThat(Validator.validateLapInput(input)).isEqualTo(expected);
	}

	@Test
	void lapNullInput() {
		assertThat(Validator.validateLapInput(null)).isFalse();
	}
}
