/*
 * Copyright (c) 2020 by 티거, 제이미
 * All rights reserved.
 *
 * @author      티거, 제이미
 * @version     1.0
 * @date        11 Feb 2020
 *
 */

package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @DisplayName("빈문자열 또는 null일 때, 0을 리턴하는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {""})
    @NullSource
    void emptyORNullIsZero(String input) {
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @DisplayName("숫자 하나일 때, 해당 숫자를 리턴하는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void oneNumber(String input) {
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("숫자 두 개를 컴마 구분자로 입력했을 때, 두 숫자를 더해줌")
    @ParameterizedTest
    @CsvSource(value = {"1,2: 3", "2,3: 5", "3,4: 7"}, delimiterString = ":")
    void twoNumbers(String input, int expected) {
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("콜론 구분자도 사용이 가능함")
    @ParameterizedTest
    @CsvSource(value = {"1:2:3, 6", "2:3, 5", "1:6:8:2, 17"})
    void delimiterColon(String input, int expected) {
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("콤마와 콜론을 섞어서도 사용이 가능함")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3_ 6", "1:2,3_ 6"}, delimiterString = "_")
    void delimiterMixColonComma(String input, int expected) {
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자도 사용이 가능함")
    @Test
    void delimiterCustom() {
        String input = "//;\n1;2;3";
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자론 마이너스도 사용이 가능함")
    @Test
    void delimiterMinus() {
        String input = "//-\n1-2-3";
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(6);
    }

    @DisplayName("숫자가 아니라면 예외를 발생시킴")
    @ParameterizedTest
    @ValueSource(strings = {"a,b", "a,b,3", "1,2,b"})
    void notNumberException(String input) {
        assertThatThrownBy(() -> StringCalculator.splitAndSum(input))
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("음수라면 예외를 발생시킴")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1,-2,3", "1,2,-3"})
    void minusException(String input) {
        assertThatThrownBy(() -> StringCalculator.splitAndSum(input))
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("커스텀 구분자로 마이너스를 쓰더라도 음수는 안 됨")
    @Test
    void delimiterMinusException() {
        String input = "//-\n1--2-3";
        assertThatThrownBy(() -> StringCalculator.splitAndSum(input))
            .isInstanceOf(RuntimeException.class);
    }
}
