import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import utils.Split;

public class split {
	@Test
	@DisplayName("콤마와 콜론으로 문자열 분리")
	void splitByCommaOrColon() {
		String value1 = "1,2:3";
		String[] result = Split.splitByCommaOrColon(value1);
		String[] expected = {"1", "2", "3"};

		assertArrayEquals(expected, result);
	}

	@Test
	@DisplayName("올바른 구분자로 파싱하는 경우")
	void splitNumberByCustomByDelimiter() {
		String value = "//;\n1;2;3";
		String[] expected = {"1", "2", "3"};
		String[] result = Split.splitNumberByCustomByDelimiter(value);

		assertArrayEquals(expected, result);
	}

	@Test
	@DisplayName("커스텀 구분자로 파싱되지 않는 경우")
	void error_splitNumberByCustomByDelimiter() {
		String value = "//;\n1;2;3";
		String[] expected = {"1", "2;3", "4"};
		String[] result = Split.splitNumberByCustomByDelimiter(value);

		Assertions.assertThat(result).isNotEqualTo(expected);
	}

	@Test
	@DisplayName("커스텀 구분자와 피연산자가 입력되지 않는 경우")
	void null_splitNumberByCustomByDelimiter() {
		Assertions.assertThatThrownBy(() -> {
			String value = "//\n1;2;3";
			Split.splitNumberByCustomByDelimiter(value);
		}).isInstanceOf(NullPointerException.class);
	}

}
