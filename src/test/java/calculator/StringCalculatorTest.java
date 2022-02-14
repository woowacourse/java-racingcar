package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class StringCalculatorTest {

    @Test
    void 기본_구분자_성공() {
        int result = StringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 슬래시_여부_확인_존재() {
        int result = StringCalculator.splitAndSum("//*\n1*2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 커스텀_구분자_입력_성공() {
        int result = StringCalculator.splitAndSum("//*\n1*2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 커스텀_구분자_미입력_실패() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("//\n1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 구분자 입력입니다.");
    }

    @Test
    void 커스텀_구분자_두개_실패() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("//**\n1**2**3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 구분자 입력입니다.");
    }

    @Test
    void 커스텀_구분자_숫자_실패() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("//1\n11213"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자로 숫자를 사용할 수 없습니다.");
    }

    @Test
    void 커스텀_구분자_덧셈_성공() {
        int result = StringCalculator.splitAndSum("//*\n1*2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 입력값_음수_실패() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 0 이상이어야 합니다.");
    }

    @Test
    void 입력값_문자_실패() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("a,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
