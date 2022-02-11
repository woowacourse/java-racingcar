package calculator;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@SuppressWarnings("NonAsciiCharacters")
public class StringCalculatorTest {
	@ParameterizedTest
	@NullAndEmptySource
	void 빈_문자열_또는_null값_입력(String input){
		assertThat(StringCalculator.calculate(input)).isEqualTo(0);
	}

	@Test
	void 숫자_하나만_입력(){
		assertThat(StringCalculator.calculate("1")).isEqualTo(1);
	}

	@Test
	void 커스텀_구분자가_존재하는_문자열_입력() {
		assertThat(StringCalculator.calculate("//;\n1;2,3")).isEqualTo(6);
		assertThat(StringCalculator.calculate("//!\n1,2!3!4")).isEqualTo(10);
	}

	@Test
	void 숫자_이외의_타입_입력() {
		assertThatThrownBy(() -> StringCalculator.calculate("//;\n1:a,3")).isInstanceOf(RuntimeException.class);
	}

	@Test
	void 음수_입력() {
		assertThatThrownBy(() -> StringCalculator.calculate("-3,2:1")).isInstanceOf(RuntimeException.class);

	}

	@Test
	void 소수_입력(){
		assertThatThrownBy(() -> StringCalculator.calculate("0.5,1.2:2")).isInstanceOf(RuntimeException.class);
	}
}
