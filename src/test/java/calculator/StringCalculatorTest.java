package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

// 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
public class StringCalculatorTest {
	@Test
	public void splitAndSum_null_또는_빈문자() throws Exception {
		int result = StringCalculator.splitAndSum(null);
		assertThat(result).isEqualTo(0);

		result = StringCalculator.splitAndSum("");
		assertThat(result).isEqualTo(0);
	}

	@Test
	public void splitAndSum_숫자하나() throws Exception {
		int result = StringCalculator.splitAndSum("1");
		assertThat(result).isEqualTo(1);
	}
}
