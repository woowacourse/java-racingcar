package calculator;

import static calculator.domain.StringSplitter.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringSplitterTest {
	private List<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@ParameterizedTest
	@DisplayName(",나 :를 구분자로 식을 입력한 경우")
	@ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
	void splitDefaultDelimiterTest(String exp) {
		Assertions.assertThat(splitString(exp)).isEqualTo(numbers);
	}

	@ParameterizedTest
	@DisplayName("사용자가 구분자를 지정한 경우")
	@ValueSource(strings = {"//;\n1;2;3", "//a\n1a2a3"})
	void splitCustomDelimiterTest(String exp) {
		Assertions.assertThat(splitString(exp)).isEqualTo(numbers);
	}
}
