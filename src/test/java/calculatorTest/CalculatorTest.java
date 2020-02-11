package calculatorTest;

import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @Test
    @DisplayName("빈 문자열 혹은 null 이 입력됐을 경우")
    void splitAndSum_null_또는_빈문자() {
        int result = Calculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = Calculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우")
    void splitAndSum_숫자하나() {
        int result = Calculator.splitAndSum("2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("숫자 두개를 컴마 구분자로 입력할 경우 합 반환")
    void splitAndSum_쉼표구분자() {
        int result = Calculator.splitAndSum("2,4");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("구분자를 컴마 이외의 콜론을 사용할 경우 합 반환")
    void splitAndSum_쉼표_혹은_콜론_구분자() {
        int result = Calculator.splitAndSum("2:4,1");
        assertThat(result).isEqualTo(7);

        result = Calculator.splitAndSum("3,2:5");
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("//와 \n 문자 사이에 커스텀 구분자를 지정할 수 있음")
    void splitAndSum_custom_구분자() {
        int result = Calculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);

        result = Calculator.splitAndSum("1:2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생하게 됨")
    void splitAndSum_negative() {
        assertThatThrownBy(()->{
            int result = Calculator.splitAndSum("1,2,-3");
        }).isInstanceOf(RuntimeException.class)
        .hasMessageContaining("음수는 포함할 수 없습니다.");

        assertThatThrownBy(()->{
            int result = Calculator.splitAndSum("//;\n1;-2;3");
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수는 포함할 수 없습니다.");
    }
}
