package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

public class StringCalculatorTest {
	static Stream<String> blankStrings() {
		return Stream.of("", null);
	}

	@ParameterizedTest
	@MethodSource("blankStrings")
	public void 빈_문자열_널_0_반환_테스트(String input) {
		assertThat(StringCalculator.splitAndSum(input)).isEqualTo(0);
	}

	@Test
	public void 쉼표_콜론_구분_테스트() {
		assertThat(StringCalculator.splitAndSum("1,2:3")).isEqualTo(6);
	}

	@Test
	public void 숫자_하나_반환_테스트() {
		assertThat(StringCalculator.splitAndSum("1")).isEqualTo(1);
	}

	@Test
	public void 빈_배열_예외_테스트() {
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> {
				StringCalculator.splitAndSum("::,,");
			}).withMessageMatching("전달된 배열에 원소가 없습니다.");
	}

	@Test
	public void 음수_예외_테스트() {
		assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2"))
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("음수 값은 포함될 수 없습니다.");
	}
}
