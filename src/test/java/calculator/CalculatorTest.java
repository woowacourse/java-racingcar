package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 계산기 테스트 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/11
 */
public class CalculatorTest {
	@Test
	@DisplayName("덧셈 테스트")
	void sum() {
		String input = "1,2,3";
		Assertions.assertThat(Calculator.calculate(input)).isEqualTo(6);
	}

	@Test
	@DisplayName("구분자가 주어졌을 때의 덧셈 테스트")
	void sum_구분자가_주어진_경우() {
		String input = "//;\n1;2;3";
		Assertions.assertThat(Calculator.calculate(input)).isEqualTo(6);
	}
}
