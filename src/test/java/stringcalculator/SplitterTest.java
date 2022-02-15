package stringcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SplitterTest {
	@Test
	void 쉼표_구분자() {
		String[] expected = {"1", "2"};
		assertThat(Splitter.split("1,2")).isEqualTo(expected);
	}

	@Test
	void 콜론_구분자() {
		String[] expected = {"1", "2"};
		assertThat(Splitter.split("1:2")).isEqualTo(expected);
	}

	@Test
	void 기본_구분자() {
		String[] expected = {"1", "2", "3"};
		assertThat(Splitter.split("1,2:3")).isEqualTo(expected);
	}

	@ParameterizedTest
	@ValueSource(strings = {"//+\n1+2+3", "//;\n1;2;3"})
	void 커스텀_구분자(String input) {
		String[] actual = Splitter.splitCustomDelimiter(input);
		String[] expected = {"1", "2", "3"};
		assertThat(actual).isEqualTo(expected);
	}
}
