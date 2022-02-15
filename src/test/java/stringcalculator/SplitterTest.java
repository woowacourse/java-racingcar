package stringcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SplitterTest {

	@Test
	@DisplayName("기본 구분자 테스트")
	void defaultDelimiterTest() {
		String[] expected = {"1", "2", "3"};
		assertThat(Splitter.split("1,2:3")).isEqualTo(expected);
	}

	@ParameterizedTest
	@ValueSource(strings = {"//+\n1+2+3", "//;\n1;2;3"})
	@DisplayName("커스텀 구분자 테스트")
	void customDelimiterTest(String input) {
		String[] actual = Splitter.splitCustomDelimiter(input);
		String[] expected = {"1", "2", "3"};
		assertThat(actual).isEqualTo(expected);
	}
}
