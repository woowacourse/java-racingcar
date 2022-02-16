package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	Calculator calculator = new Calculator();

	//1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다
	@DisplayName("빈문자열, null 테스트")
	@Test
	public void splitAndSum_null_또는_빈문자() throws Exception {
		int result = calculator.splitAndSum(null);
		assertThat(result).isEqualTo(0);

		result = calculator.splitAndSum("");
		assertThat(result).isEqualTo(0);
	}

	@Test
	public void splitAndSum_숫자하나() throws Exception {
		int result = calculator.splitAndSum("1");
		assertThat(result).isEqualTo(1);
	}

	@Test
	public void splitAndSum_숫자하나_번외() throws Exception {
		int result = calculator.splitAndSum("2");
		assertThat(result).isEqualTo(2);
	}
}
