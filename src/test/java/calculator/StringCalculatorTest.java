package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	@Test
	@DisplayName("검증에 걸리는 요소를 포함시킨 경우 - 숫자가 아닌 값")
	void inputNotNumber() {
		List<String> stringNumbers = new ArrayList<>();
		stringNumbers.add("a");
		assertThatThrownBy(() -> StringCalculator.calculate(stringNumbers))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("검증에 걸리는 요소를 포함시킨 경우 - 빈 문자열")
	void inputEmptyString() {
		List<String> stringNumbers = new ArrayList<>();
		stringNumbers.add("");
		assertThatThrownBy(() -> StringCalculator.calculate(stringNumbers))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("검증에 걸리는 요소를 포함시킨 경우 - 음수")
	void inputNegativeNumber() {
		List<String> stringNumbers = new ArrayList<>();
		stringNumbers.add("-1");
		assertThatThrownBy(() -> StringCalculator.calculate(stringNumbers))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("숫자 하나만 있는 경우")
	void inputSingleNumber(){
		List<String> stringNumbers = new ArrayList<>();
		stringNumbers.add("1");
		assertThat(StringCalculator.calculate(stringNumbers)).isEqualTo(1);
	}

	@Test
	@DisplayName("숫자 여러 개 있는 경우")
	void inputNumbers(){
		List<String> stringNumbers = new ArrayList<>();
		stringNumbers.add("1");
		stringNumbers.add("2");
		stringNumbers.add("3");
		assertThat(StringCalculator.calculate(stringNumbers)).isEqualTo(6);
	}
}
