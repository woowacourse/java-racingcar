package tdd.calculator.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputUtilsTest {
	@Test
	void splitValuesForComma() {
		String[] actual = InputUtils.split("1,2");
		String[] expected = {"1", "2"};
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void splitValuesForColon() {
		String[] actual = InputUtils.split("1:2:3");
		String[] expected = {"1", "2", "3"};
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void splitValuesForCommaAndColon() {
		String[] actual = InputUtils.split("1,2:3");
		String[] expected = {"1", "2", "3"};
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void splitValuesForCustomDelimiter() {
		String[] actual = InputUtils.split("//;\n1;2;3");
		String[] expected = {"1", "2", "3"};
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void splitValuesForMixedDelimiter() {
		String[] actual = InputUtils.split("//;\n1;2,3:4");
		String[] expected = {"1", "2", "3", "4"};
		assertThat(actual).isEqualTo(expected);
	}
}