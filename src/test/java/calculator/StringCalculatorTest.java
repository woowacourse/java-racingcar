package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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

    @Test
    public void 숫자_아닌_원소_예외_테스트() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("1,안녕하세요:3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("전달된 배열의 원소는 반드시 숫자여야 합니다.");
    }

    @Test
    public void 커스텀_구분자_테스트() {
        assertThat(StringCalculator.splitAndSum("//;\n1;2")).isEqualTo(3);
    }

    @Test
    public void 커스텀_구분자_없는_경우_예외_테스트() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("//\n1;2"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("커스텀 구분자가 입력되지 않았습니다.");
    }

    @Test
    public void 커스텀_구분자_여러_글자_예외_테스트() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("//^^\n1;2"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("커스텀 구분자는 한 글자여야 합니다.");
    }

    @Test
    public void 커스텀_구분자_정수가_아닌_글자_예외_테스트() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("//3\n1;2"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("정수는 커스텀 구분자로 지정할 수 없습니다.");
    }
}

