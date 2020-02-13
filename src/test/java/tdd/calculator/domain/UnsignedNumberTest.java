package tdd.calculator.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnsignedNumberTest {
	@Test
	void getValue() {
		final UnsignedNumber one = new UnsignedNumber("1");
		final int expected = 1;
		final int actual = one.getValue();
		assertEquals(expected, actual);
	}
}