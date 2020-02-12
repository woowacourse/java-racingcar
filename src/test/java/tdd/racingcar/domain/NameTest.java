package tdd.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NameTest {
	private static final String TOO_LONG_NAME = "abcdefg";

	@Test
	void constructor() {
		assertThatIllegalArgumentException().isThrownBy(() ->
			new Name(TOO_LONG_NAME))
			.withMessage("이름은 최대 5자까지 가능합니다.");
	}
}
