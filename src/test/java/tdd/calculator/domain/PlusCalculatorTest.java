package tdd.calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlusCalculatorTest {
	@Test
	void plusTwoNumberSplitByComma() {
		final String value = "1,2";
		final int actual = PlusCalculator.calculate(value);
		final int expected = 3;
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void plusNumbersSplitByComma() {
		final String threeValues = "1,2,3";
		final int actualForThreeValues = PlusCalculator.calculate(threeValues);
		final int expectedForThreeValues = 6;
		assertThat(actualForThreeValues).isEqualTo(expectedForThreeValues);

		final String fourValues = "1,2,3,4";
		final int actualForFourValues = PlusCalculator.calculate(fourValues);
		final int expectedForFourValues = 10;
		assertThat(actualForFourValues).isEqualTo(expectedForFourValues);
	}

	@Test
	void plusTwoNumberSplitByColon() {
		final String value = "1:2";
		final int actual = PlusCalculator.calculate(value);
		final int expected = 3;
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void plusNumbersSplitByColon() {
		final String threeValues = "1:2:3";
		final int actualForThreeValues = PlusCalculator.calculate(threeValues);
		final int expectedForThreeValues = 6;
		assertThat(actualForThreeValues).isEqualTo(expectedForThreeValues);

		final String fourValues = "1:2:3:4";
		final int actualForFourValues = PlusCalculator.calculate(fourValues);
		final int expectedForFourValues = 10;
		assertThat(actualForFourValues).isEqualTo(expectedForFourValues);
	}

	@Test
	void plusNumbersSplitByCommaAndColon() {
		final String threeValues = "1,2:3";
		final int actualForThreeValues = PlusCalculator.calculate(threeValues);
		final int expectedForThreeValues = 6;
		assertThat(actualForThreeValues).isEqualTo(expectedForThreeValues);

		final String fourValues = "1:2,3:4";
		final int actualForFourValues = PlusCalculator.calculate(fourValues);
		final int expectedForFourValues = 10;
		assertThat(actualForFourValues).isEqualTo(expectedForFourValues);
	}

	@Test
	void plusNumbersSplitByCustomDelimiter() {
		final String customValue = "//;\n1;2;3";
		final int expected = 6;
		final int actual = PlusCalculator.calculate(customValue);
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void plusNumbersSplitByMixedDelimiter() {
		final String customValue = "//;\n1;2,3:4";
		final int expected = 10;
		final int actual = PlusCalculator.calculate(customValue);
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void plusForNegativeNumber() {
		final String customValue = "//;\n1;2,-3:4";
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> PlusCalculator.calculate(customValue));
	}

	@Test
	void plusForNotNumber() {
		final String customValue = "//;\n1;2,a,3,4";
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> PlusCalculator.calculate(customValue));
	}

	@Test
	public void calculate_null_또는_빈문자() {
		int result = PlusCalculator.calculate(null);
		assertThat(result).isEqualTo(0);

		result = PlusCalculator.calculate("");
		assertThat(result).isEqualTo(0);
	}

	@Test
	public void calculate_숫자하나() throws Exception {
		int result = PlusCalculator.calculate("1");
		assertThat(result).isEqualTo(1);
	}

	@Test
	public void calculate_쉼표구분자() throws Exception {
		int result = PlusCalculator.calculate("1,2");
		assertThat(result).isEqualTo(3);
	}

	@Test
	public void calculate_쉼표_또는_콜론_구분자() throws Exception {
		int result = PlusCalculator.calculate("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void calculate_custom_구분자() throws Exception {
		int result = PlusCalculator.calculate("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void calculate_negative() throws Exception {
		assertThatThrownBy(() -> PlusCalculator.calculate("-1,2,3"))
				.isInstanceOf(RuntimeException.class);
	}
}
