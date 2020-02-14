package tdd.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {
	private static final String TOO_LONG_NAME = "abcdefg";

	@Test
	@DisplayName("이름이 5자를 초과할 때 예외 발생 테스트")
	void testTooLongName() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new Name(TOO_LONG_NAME))
				.withMessage("이름은 최대 5자까지 가능합니다.");
	}
}
