package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {
	@ParameterizedTest
	@ValueSource(strings = {"withoutcomma", "", " "})
	void invalidStringInput(String input) {
		assertThat(Validator.validate(input)).isFalse();
	}
	@Test
	void nullInput(){
		assertThat(Validator.validate(null)).isFalse();
	}
}
