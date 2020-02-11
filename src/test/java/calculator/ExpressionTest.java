package calculator;

import org.junit.jupiter.api.Test;

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
}
