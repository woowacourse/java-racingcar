package tdd.racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TryCountTest {
	private static final String NOT_NUMBER_INPUT = "A";
	private static final String ZERO_INPUT = "0";

	@Test
	void canValidateRoundForNotNumber() {
		assertThatIllegalArgumentException().isThrownBy(() ->
			new TryCount(NOT_NUMBER_INPUT))
			.withMessage("횟수는 숫자이어야 합니다.");
	}

	@Test
	void canValidateRoundForZero() {
		assertThatIllegalArgumentException().isThrownBy(() ->
			new TryCount(ZERO_INPUT))
			.withMessage("횟수는 1이상 이어야 합니다.");
	}

	@Test
	void consume() {
		final TryCount tryCount = new TryCount("2");
		final TryCount expected = new TryCount("1");
		final TryCount actual = tryCount.consume();
		assertEquals(expected, actual);
	}

	@Test
	void isLastRound() {
		final TryCount two = new TryCount("2");
		assertTrue(two.isLastRound());

		final TryCount one = two.consume();
		assertFalse(one.isLastRound());
	}
}
