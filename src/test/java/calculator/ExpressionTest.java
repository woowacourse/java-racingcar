package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ExpressionTest {
	@Test
	void 최종식반환() {
		String value = "//;\n1;2:3,4";
		String expected = Expression.getFinalExpression(value);
		assertThat(expected).isEqualTo("1:2:3:4");

		value = "1,4,3:5";
		expected = Expression.getFinalExpression(value);
		assertThat(expected).isEqualTo("1:4:3:5");
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1:3:4", "1:3^4", "1,3:4"})
	void 식검증(String expression) {
		assertThatThrownBy(() -> Expression.validate(expression))
				.isInstanceOf(RuntimeException.class);
	}
}
