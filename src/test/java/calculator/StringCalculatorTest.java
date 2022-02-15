package calculator;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	@Test
	@DisplayName("splitAndSum_null_또는_빈문자")
	public void splitAndSum_null() throws Exception {
		int result = StringCalculator.splitAndSum(null);
		assertThat(result).isEqualTo(0);

		result = StringCalculator.splitAndSum("");
		assertThat(result).isEqualTo(0);
	}

	@Test
	@DisplayName("splitAndSum_숫자하나")
	public void splitAndSum_one_digit() throws Exception {
		int result = StringCalculator.splitAndSum("1");
		assertThat(result).isEqualTo(1);
	}

	@Test
	@DisplayName("splitAndSum_쉼표구분자")
	public void splitAndSumWithComma() throws Exception {
		int result = StringCalculator.splitAndSum("1,2");
		assertThat(result).isEqualTo(3);
	}

	@Test
	@DisplayName("splitAndSum_쉼표_또는_콜론_구분자")
	public void splitAndSum_CommaOrColon() throws Exception {
		int result = StringCalculator.splitAndSum("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	@DisplayName("splitAndSum_custom_구분자")
	public void splitAndSum_custom_separator() throws Exception {
		int result = StringCalculator.splitAndSum("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	@DisplayName("splitAndSum_음수")
	public void splitAndSum_negative() throws Exception {
		assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}
}
