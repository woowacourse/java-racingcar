package racingcar.validator;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarNameValidatorTest {
	@Test
	void 이름_글자수_체크(){
		assertThatThrownBy(()->CarNameValidator.validate("abcdef"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 이름_유효성_체크(){
		assertThatThrownBy(()->CarNameValidator.validate(""))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(()->CarNameValidator.validate("  "))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
