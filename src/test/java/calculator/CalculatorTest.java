package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
	@DisplayName("연산 테스트")
	void calculate() {
		List<Integer> numbers = Arrays.asList(1, 2, 3);
		Assertions.assertThat(Calculator.calculate(numbers))
				.isEqualTo(6);
	}

	@Test
	@DisplayName("연산의 입력값으로 null 리스트가 주어진 경우")
	void calculate_연산의_입력값으로_null이_주어진_경우() {
		Assertions.assertThatThrownBy(() -> Calculator.calculate(null))
				.isInstanceOf(NullPointerException.class);
	}

	@Test
	@DisplayName("연산의 입력값으로 길이가 0인 리스트가 주어진 경우")
	void calculate_연산의_입력값으로_길이가_0인_리스트가_주어진_경우() {
		Assertions.assertThatThrownBy(() -> Calculator.calculate(new ArrayList<>()))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("숫자가 한 개 이상 주어져아 합니다.");
	}

	@ParameterizedTest
	@DisplayName("문자열 자르기 테스트")
	@ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
	void splitByDelimiter(String input) {
		Assertions.assertThat(Calculator.splitByDelimiter(input))
				.isEqualTo(Arrays.asList(1, 2, 3));
	}

	@Test
	@DisplayName("구분자가 주어졌을 때의 문자열 자르기 테스트")
	void splitByDelimiter_구분자가_주어진_경우() {
		String input = "//;\n1;2;3";
		Assertions.assertThat(Calculator.splitByDelimiter(input))
				.isEqualTo(Arrays.asList(1, 2, 3));
	}

	@ParameterizedTest
	@DisplayName("구분자가 제대로 주어지지 않았을 때의 문자열 자르 테스트")
	@ValueSource(strings = {"//;1;2;3", "//!@#\n1#2#3"})
	void splitByDelimiter_구분자가_올바르지_않은_경우(String input) {
		Assertions.assertThatThrownBy(() -> Calculator.splitByDelimiter(input))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("invalid input");
	}

	@ParameterizedTest
	@DisplayName("숫자가 제대로 주어지지 않았을 때의 덧셈 테스트")
	@ValueSource(strings = {"//;\n1d;2;3"})
	void splitByDelimiter_숫자가_올바르지_않은_경우(String input) {
		Assertions.assertThatThrownBy(() -> Calculator.splitByDelimiter(input))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("invalid input");
	}
}
