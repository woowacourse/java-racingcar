package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "", "-1"})
    @DisplayName("검증에 걸리는 요소를 포함시킨 경우 예외발생")
    void checkInvalidateInput(String text) {
        List<String> stringNumbers = new ArrayList<>();
        stringNumbers.add(text);
        assertThatThrownBy(() -> StringCalculator.calculate(stringNumbers))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자 하나만 있는 경우")
    void inputSingleNumber() {
        List<String> stringNumbers = new ArrayList<>();
        stringNumbers.add("1");
        assertThat(StringCalculator.calculate(stringNumbers)).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 여러 개 있는 경우")
    void inputNumbers() {
        List<String> stringNumbers = new ArrayList<>();
        stringNumbers.add("1");
        stringNumbers.add("2");
        stringNumbers.add("3");
        assertThat(StringCalculator.calculate(stringNumbers)).isEqualTo(6);
    }
}
