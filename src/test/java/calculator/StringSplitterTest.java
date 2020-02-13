package calculator;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import calculator.domain.Operand;
import calculator.domain.StringSplitter;

/**
 * 계산기 테스트 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/11
 */
public class StringSplitterTest {
	private List<Operand> operands = new ArrayList<>();

	@BeforeEach
	void initialize() {
		operands.add(new Operand(1));
		operands.add(new Operand(2));
		operands.add(new Operand(3));
	}

	@ParameterizedTest
	@DisplayName("문자열 자르기 테스트")
	@ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
	void splitByDelimiter(String input) {
		Assertions.assertThat(StringSplitter.splitByDelimiter(input))
				.isEqualTo(operands);
	}

	@Test
	@DisplayName("구분자가 주어졌을 때의 문자열 자르기 테스트")
	void splitByDelimiter_구분자가_주어진_경우() {
		String input = "//;\n1;2;3";
		Assertions.assertThat(StringSplitter.splitByDelimiter(input))
				.isEqualTo(operands);
	}

	@ParameterizedTest
	@DisplayName("구분자가 제대로 주어지지 않았을 때의 문자열 자르기 테스트")
	@ValueSource(strings = {"//;1;2;3", "//!@#\n1#2#3"})
	void splitByDelimiter_구분자가_올바르지_않은_경우(String input) {
		Assertions.assertThatThrownBy(() -> StringSplitter.splitByDelimiter(input))
				.isInstanceOf(RuntimeException.class);
	}

	@ParameterizedTest
	@DisplayName("숫자가 제대로 주어지지 않았을 때의 덧셈 테스트")
	@ValueSource(strings = {"//;\n1d;2;3", "1:2:-3"})
	void splitByDelimiter_숫자가_올바르지_않은_경우(String input) {
		Assertions.assertThatThrownBy(() -> StringSplitter.splitByDelimiter(input))
				.isInstanceOf(RuntimeException.class);
	}
}
