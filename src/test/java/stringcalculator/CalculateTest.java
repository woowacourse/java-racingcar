package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculateTest {

    private static Stream<Arguments> sourceForNegativeException() {
        return Stream.of(
                Arguments.of("1,2:-3", -3),
                Arguments.of("//;\n1;2;-5", -5)
        );
    }

    @Test
    void customPlusTest() {
        assertThat(Calculate.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2|3", "1,2,3|6", "1,2:3|6"}, delimiter = '|')
    void plusTest(String input, int result) {
        assertThat(Calculate.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("sourceForNegativeException")
    void inputNegativeThrowIllegalException(String input, int negative) {
        assertThatThrownBy(() -> Calculate.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("%d 는 음수입니다.", negative);
    }
}
