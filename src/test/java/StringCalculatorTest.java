import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {
    @DisplayName("빈칸 혹은 null 확인")
    @Test
    void splitAndSum_null() {
        int result = StringCalculator.calculate(null);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나 입력 확인")
    @Test
    void splitAndSum_Number() {
        int result = StringCalculator.calculate("3");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("디폴트 구분자 확인")
    @Test
    void splitAndSum_defaultDelimiter() {
        int result = StringCalculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자 확인")
    @Test
    void splitAndSum_customDelimiter() {
        int result = StringCalculator.calculate("//;\n1;3;4");
        assertThat(result).isEqualTo(8);
    }

    @DisplayName("예외사항 확인")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "a,2,3"})
    void exceptionHandler(String number) {
        assertThatThrownBy(() -> StringCalculator.calculate(number))
                .isInstanceOf(RuntimeException.class);
    }

}