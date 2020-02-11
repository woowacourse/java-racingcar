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

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    void 빈문자열_또는_null_테스트() {
        String input1 = null;
        assertThat(StringCalculator.splitAndSum(input1)).isEqualTo(0);
        String input2 = "";
        assertThat(StringCalculator.splitAndSum(input2)).isEqualTo(0);
    }

    @Test
    void 숫자_하나_문자열() {
        String input = "1";
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(1);
    }

    @Test
    void 숫자_두개를_컴마_구분자로_입력() {
        String input = "1,2";
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(3);
    }

    @Test
    void 콜론_구분자() {
        String input = "1,2:3";
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자() {
        String input = "//;\n1;2;3";
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(6);
    }

    @Test
    void 음수면_예외발생() {
        String input = "-1,2,3";
        assertThatThrownBy(() -> StringCalculator.splitAndSum(input))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 숫자_아니면_예외발생() {
        String input = "a,b,3";
        assertThatThrownBy(() -> StringCalculator.splitAndSum(input))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 딜리미터가_하이픈이면_예외발생() {
        String input = "//-\n1;2;3";
        assertThatThrownBy(() -> StringCalculator.splitAndSum(input))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("-");
    }
}
