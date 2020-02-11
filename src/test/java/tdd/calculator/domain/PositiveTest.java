package tdd.calculator.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PositiveTest {
	@Test
	void getPositive() {
		final Positive one = new Positive("1");
		final int expected = 1;
		final int actual = one.getPositive();
		assertEquals(expected, actual);
	}
}