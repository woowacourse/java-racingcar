package stringCalculator.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorControllerTest {
    private CalculatorController calculatorController;

    private static Stream<Arguments> provideNumbersForSplit() {
        return Stream.of(
                Arguments.of("1,2:3;4", ",|:|;", Arrays.asList(1, 2, 3, 4)),
                Arguments.of("1,2:3#4", ",|:|#", Arrays.asList(1, 2, 3, 4))
        );
    }

    private static Stream<String> provideInvalidNumbersForSplit() {
        return Stream.of("1,:3", "-1,2:3", null, "a,b,c");
    }

    @BeforeEach
    public void setUp() {
        this.calculatorController = new CalculatorController(null);
    }

    @DisplayName("정상적인 구분자인 경우 커스텀 구분자 얻기 성공")
    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3=;", "//#\\n3#6#4=#", "//&\\n3&4&9=&"}, delimiter = '=')
    public void getCustomDelimiter_정상적인_구분자인_경우(String value, String expected) {
        String customDelimiter = calculatorController.getCustomDelimiter(value);

        assertThat(customDelimiter).isEqualTo(expected);
    }

    @DisplayName("정상적인 구분자가 아닌 경우 커스텀 구분자 얻기 실패")
    @ParameterizedTest
    @ValueSource(strings = {"//,\\n1,2,3=,", "//:\\n1,2,3=,"})
    public void getCustomDelimiter_정상적인_구분자가_아닌_경우(String value) {
        assertThatThrownBy(() -> {
            calculatorController.getCustomDelimiter(value);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("숫자 문자열에서 구분자를 기준으로 숫자 분리")
    @ParameterizedTest
    @MethodSource("provideNumbersForSplit")
    public void splitNumbers_정상적인_숫자인_경우(String value, String delimiters, List<Integer> expected) {
        List<Integer> numbers = calculatorController.splitNumbers(value, delimiters);

        assertThat(numbers).isEqualTo(expected);
    }

    @DisplayName("정상적인 숫자 문자열이 아닌 경우 분리 실패")
    @ParameterizedTest
    @MethodSource("provideInvalidNumbersForSplit")
    public void splitNumbers_정상적인_숫자가_아닌_경우(String value) {
        String delimiters = ",|:";

        assertThatThrownBy(() -> {
            calculatorController.splitNumbers(value, delimiters);
        }).isInstanceOf(RuntimeException.class);
    }
}