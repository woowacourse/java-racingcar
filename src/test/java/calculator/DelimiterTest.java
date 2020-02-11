package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class DelimiterTest {
	@Test
	void 구분자반환() {
		String value = "//;\n1;2;3";
		String expected = Delimiter.getDelimiter(value);
		assertThat(expected).isEqualTo(";");

		value = "1:2,3";
		expected = Delimiter.getDelimiter(value);
		assertThat(expected).isEqualTo(":");
	}
}
