package tdd.racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PowerTest {
	@Test
	void constructor() {
		final int overPower = 10;
		final int underPower = -1;
		assertThatIllegalArgumentException().isThrownBy(() -> new Power(overPower));
		assertThatIllegalArgumentException().isThrownBy(() -> new Power(underPower));
	}

	@Test
	void isEnough() {
		final Power enoughPower = new Power(4);
		final Power notEnoughPower = new Power(3);
		assertTrue(enoughPower.isEnough());
		assertFalse(notEnoughPower.isEnough());
	}
}
