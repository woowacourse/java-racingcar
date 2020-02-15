package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @Test
    void 빈문자열_널_체크() {
        int result = StringCalculator.calculate(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자하나입력시() {
        int result = StringCalculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 덧셈_테스트() {
        int result = StringCalculator.calculate("1,2:3:4,5");
        assertThat(result).isEqualTo(1 + 2 + 3 + 4 + 5);
    }

    @Test
    void 커스텀_구분자() {
        int result = StringCalculator.calculate("//;//1;2;4;5");
        assertThat(result).isEqualTo(12);
    }

    @Test
    void 커스텀_구분자_에러() {
        assertThatThrownBy(() -> {
            StringCalculator.calculate("//@//1;2;4;5");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 커스텀_음수_및_숫자이외() {
        assertThatThrownBy(() -> {
            StringCalculator.calculate("//;//-1;2");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 디폴트_음수_및_숫자이외() {
        assertThatThrownBy(() -> {
            StringCalculator.calculate("-1:2");
        }).isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> {
            StringCalculator.calculate("a:2");
        }).isInstanceOf(RuntimeException.class);
    }
}
