package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void 커스텀_구분자_미입력_실패() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("//\n1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("올바르지 않은 구분자 입력입니다.");
    }

    @Test
    void 커스텀_구분자_두개_실패() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("//**\n1**2**3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("올바르지 않은 구분자 입력입니다.");
    }

    @Test
    void 커스텀_구분자_숫자_실패() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("//1\n11213"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("구분자로 숫자를 사용할 수 없습니다.");
    }

}
