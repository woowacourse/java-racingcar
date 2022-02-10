package racingcar.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RoundNumberValidatorTest {
	@Test
	void 자연수_체크(){
		assertThatThrownBy(()->RoundNumberValidator.validate("0"))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(()->RoundNumberValidator.validate("1.33"))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(()->RoundNumberValidator.validate("abc"))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(()->RoundNumberValidator.validate("-23"))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
