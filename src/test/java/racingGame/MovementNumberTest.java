package racingGame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MovementNumberTest {
	@Test
	void checkValidMovementNumber_이동_횟수가_숫자가_아닌_경우() {
		final String invalidMovementNumber = "abc";

		assertThatThrownBy(() -> new MovementNumber(invalidMovementNumber))
			.isInstanceOf(NumberFormatException.class);
	}

	@Test
	void checkPositiveMovementNumber_이동_횟수가_음수() {
		final String invalidMovementNumber = "-1";

		assertThatThrownBy(() -> new MovementNumber(invalidMovementNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
