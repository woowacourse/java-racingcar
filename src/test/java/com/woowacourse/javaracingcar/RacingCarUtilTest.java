package com.woowacourse.javaracingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarUtilTest {
    @Test
    void 정상이름_입력() {
        String input = "pobi,crong,honux";
        assertThat(RacingCarUtil.isValidNameInput(RacingCarUtil.splitIntoNames(input))).isTrue();
    }

    @Test
    void 비정상_이름_입력_5자초과() {
        String input = "pobi,crong,honuxxx";

        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarUtil.isValidNameInput(RacingCarUtil.splitIntoNames(input));
        });
    }

    @Test
    void 정상이름_입력_공백처리() {
        String input = "pobi   ,  crong,  honux   ";
        assertThat(RacingCarUtil.isValidNameInput(RacingCarUtil.splitIntoNames(input))).isTrue();
    }

    @Test
    void 공백처리_예외() {
        String input  = "p obi, crong, ho  x";
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarUtil.isValidNameInput(RacingCarUtil.splitIntoNames(input));
        });
    }
}