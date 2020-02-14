package tdd.calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlusCalculatorTest {
	@Test
	void plusTwoNumberSplitByComma() {
		int actual = PlusCalculator.calculate("1,2");
		int expected = 3;
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void plusNumbersSplitByComma() {
		int actualForThreeValues = PlusCalculator.calculate("1,2,3");
		int expectedForThreeValues = 6;
		assertThat(actualForThreeValues).isEqualTo(expectedForThreeValues);

		int actualForFourValues = PlusCalculator.calculate("1,2,3,4");
		int expectedForFourValues = 10;
		assertThat(actualForFourValues).isEqualTo(expectedForFourValues);
	}

	@Test
	void plusTwoNumberSplitByColon() {
		int actual = PlusCalculator.calculate("1:2");
		int expected = 3;
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void plusNumbersSplitByColon() {
		int actualForThreeValues = PlusCalculator.calculate("1:2:3");
		int expectedForThreeValues = 6;
		assertThat(actualForThreeValues).isEqualTo(expectedForThreeValues);

		int actualForFourValues = PlusCalculator.calculate("1:2:3:4");
		int expectedForFourValues = 10;
		assertThat(actualForFourValues).isEqualTo(expectedForFourValues);
	}

	@Test
	void plusNumbersSplitByCommaAndColon() {
		int actualForThreeValues = PlusCalculator.calculate("1,2:3");
		int expectedForThreeValues = 6;
		assertThat(actualForThreeValues).isEqualTo(expectedForThreeValues);

		int actualForFourValues = PlusCalculator.calculate("1:2,3:4");
		int expectedForFourValues = 10;
		assertThat(actualForFourValues).isEqualTo(expectedForFourValues);
	}

	@Test
	void plusNumbersSplitByCustomDelimiter() {
		int actual = PlusCalculator.calculate("//;\n1;2;3");
		int expected = 6;
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void plusNumbersSplitByMixedDelimiter() {
		int actual = PlusCalculator.calculate("//;\n1;2,3:4");
		int expected = 10;
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void plusForNegativeNumber() {
		assertThatExceptionOfType(RuntimeException.class)
				.isThrownBy(() -> PlusCalculator.calculate("//;\n1;2,-3:4"));
	}

	@Test
	void plusForNotNumber() {
		assertThatExceptionOfType(RuntimeException.class)
				.isThrownBy(() -> PlusCalculator.calculate("//;\n1;2,a,3,4"));
	}

	@Test
	@SuppressWarnings("NonAsciiCharacters")
	public void calculate_null_또는_빈문자() {
		int result = PlusCalculator.calculate(null);
		assertThat(result).isEqualTo(0);

		result = PlusCalculator.calculate("");
		assertThat(result).isEqualTo(0);
	}

	@Test
	@SuppressWarnings("NonAsciiCharacters")
	public void calculate_숫자하나() throws Exception {
		int result = PlusCalculator.calculate("1");
		assertThat(result).isEqualTo(1);
	}

	@Test
	@SuppressWarnings("NonAsciiCharacters")
	public void calculate_쉼표구분자() throws Exception {
		int result = PlusCalculator.calculate("1,2");
		assertThat(result).isEqualTo(3);
	}

	@Test
	@SuppressWarnings("NonAsciiCharacters")
	public void calculate_쉼표_또는_콜론_구분자() throws Exception {
		int result = PlusCalculator.calculate("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	@SuppressWarnings("NonAsciiCharacters")
	public void calculate_custom_구분자() throws Exception {
		int result = PlusCalculator.calculate("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	@SuppressWarnings("NonAsciiCharacters")
	public void calculate_negative() throws Exception {
		assertThatThrownBy(() -> PlusCalculator.calculate("-1,2,3"))
				.isInstanceOf(RuntimeException.class);
	}
}
