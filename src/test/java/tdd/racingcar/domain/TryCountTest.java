package tdd.racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TryCountTest {
	private static final String NOT_NUMBER_INPUT = "A";
	private static final String MIXED_INPUT = "A1B2";
	private static final String ZERO_INPUT = "0";

	@Test
	void canValidateTryCountForNotNumber() {
		assertThatIllegalArgumentException().isThrownBy(() ->
			new TryCount(NOT_NUMBER_INPUT))
			.withMessage("횟수는 숫자이어야 합니다.");
	}

	@Test
	void canValidateTryCountForZero() {
		assertThatIllegalArgumentException().isThrownBy(() ->
			new TryCount(ZERO_INPUT))
			.withMessage("횟수는 1이상 이어야 합니다.");
	}

	@Test
	void canValidateTryCountForMixedInput() {
		assertThatIllegalArgumentException().isThrownBy(() ->
			new TryCount(MIXED_INPUT))
			.withMessage("횟수는 숫자이어야 합니다.");
	}

	@Test
	void consume() {
		final TryCount tryCount = new TryCount("2");
		tryCount.consume();
		final TryCount expected = new TryCount("1");
		assertEquals(expected, tryCount);
	}

	@Test
	void isRemain() {
		final TryCount two = new TryCount("2");
		assertTrue(two.isRemain());
		two.consume();
		assertTrue(two.isRemain());
		two.consume();
		assertFalse(two.isRemain());
	}
}
