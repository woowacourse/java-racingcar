package stringcalculator.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    private static final String DEFAULT_DELIMITERS = ",|:";
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

    @DisplayName("전체 문자열에서 숫자 분리")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3=1,2,3", "1:2:3=1:2:3", "//;\\n1;2;3=1;2;3"}, delimiter = '=')
    public void getNumbers_숫자_분리(String value, String expected) {
        String numbers = calculatorController.getNumbers(value);

        assertThat(numbers).isEqualTo(expected);
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
        assertThatThrownBy(() -> {
            calculatorController.splitNumbers(value, DEFAULT_DELIMITERS);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    @Test
    public void splitAndSum_숫자하나() {
        int result = calculatorController.splitAndSum("1", DEFAULT_DELIMITERS);
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("정상적인 숫자 문자열이 입력된 경우 숫자를 분리 후 더하여 반환")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3=6", "1,2:3=6"}, delimiter = '=')
    public void splitAndSum_정상적인_문자열(String value, String expected) {
        int result = calculatorController.splitAndSum(value, DEFAULT_DELIMITERS);
        int expectedNumber = Integer.parseInt(expected);

        assertThat(result).isEqualTo(expectedNumber);
    }

    @DisplayName("정상적인 숫자 문자열이 입력된 경우 숫자를 분리 후 더하여 반환")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3=6", "1,2:3=6", "//;\\n1;2,3=6"}, delimiter = '=')
    public void getResult_정상적인_문자열(String value, String expected) {
        int result = calculatorController.parseAndSum(value);
        int expectedNumber = Integer.parseInt(expected);

        assertThat(result).isEqualTo(expectedNumber);
    }

    @DisplayName("숫자 문자열이 null 또는 빈문자인 경우 0을 반환")
    @Test
    public void getResult_null_또는_빈문자() {
        int result = calculatorController.parseAndSum(null);
        assertThat(result).isEqualTo(0);

        result = calculatorController.parseAndSum("");
        assertThat(result).isEqualTo(0);
    }
}