package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	Calculator calculator = new Calculator();

	@DisplayName("빈문자열, null 테스트")
	@Test
	public void splitAndSum_null_또는_빈문자() throws Exception {
		int result = calculator.splitAndSum(null);
		assertThat(result).isEqualTo(0);

		result = calculator.splitAndSum("");
		assertThat(result).isEqualTo(0);
	}

	@DisplayName("숫자가 하나일 경우")
	@Test
	public void splitAndSum_숫자하나() throws Exception {
		int result = calculator.splitAndSum("1");
		assertThat(result).isEqualTo(1);
	}

	@DisplayName("쉼표 구분자 테스트")
	@Test
	public void splitAndSum_쉼표구분자() throws Exception {
		int result = calculator.splitAndSum("1,2");
		assertThat(result).isEqualTo(3);
	}

	@DisplayName("쉼표, 콜론 구분자 테스트")
	@Test
	public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
		int result = calculator.splitAndSum("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@DisplayName("중간에 공백 들어올 때 테스트")
	@Test
	public void splitAndSum_중간_공백_테스트() throws Exception {
		int result = calculator.splitAndSum("1,:3");
		assertThat(result).isEqualTo(4);
	}

	@DisplayName("사용자가 추가한 구분자 테스트")
	@Test
	public void splitAndSum_custom_구분자() throws Exception {
		int result = calculator.splitAndSum("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@DisplayName("음수일 경우 테스트")
	@Test
	public void splitAndSum_negative() throws Exception {
		assertThatThrownBy(() -> calculator.splitAndSum("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("값이 문자일 경우 테스트")
	@Test
	public void splitAndSum_string_value_test() throws Exception {
		assertThatThrownBy(() -> calculator.splitAndSum("1,일곱,3"))
			.isInstanceOf(IllegalArgumentException.class);
	}
}