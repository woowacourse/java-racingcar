package tdd.calculator.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputUtilsTest {
	@Test
	void splitValuesForComma() {
		final String value = "1,2";
		final String[] actual = InputUtils.split(value);
		final String[] expected = {"1", "2"};
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void splitValuesForColon() {
		final String value = "1:2:3";
		final String[] actual = InputUtils.split(value);
		final String[] expected = {"1", "2", "3"};
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void splitValuesForCommaAndColon() {
		final String value = "1,2:3";
		final String[] actual = InputUtils.split(value);
		final String[] expected = {"1", "2", "3"};
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void splitValuesForCustomDelimiter() {
		final String customValue = "//;\n1;2;3";
		final String[] actual = InputUtils.split(customValue);
		final String[] expected = {"1", "2", "3"};
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void splitValuesForMixedDelimiter() {
		final String customValue = "//;\n1;2,3:4";
		final String[] actual = InputUtils.split(customValue);
		final String[] expected = {"1", "2", "3", "4"};
		assertThat(actual).isEqualTo(expected);
	}
}