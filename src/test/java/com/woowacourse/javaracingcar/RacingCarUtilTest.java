package com.woowacourse.javaracingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class RacingCarUtilTest {
    @Test
    void 정상이름_입력() {
        String input = "pobi,crong,honux";
        assertThat(RacingCarUtil.isValidNameInput(RacingCarUtil.splitIntoNames(input))).isTrue();
    }

    @Test
    void 비정상_이름_입력_5자초과() {
        String input = "pobi,crong,honuxxx";

        assertThat(RacingCarUtil.isValidNameInput(RacingCarUtil.splitIntoNames(input)))
            .isFalse();
    }

    @Test
    void 비정상_이름_입력() {
        String input = ", ";
        assertThat(RacingCarUtil.isValidNameInput(RacingCarUtil.splitIntoNames(input)))
            .isFalse();
    }

    @Test
    void 정상이름_입력_공백처리() {
        String input = "pobi   ,  crong,  honux   ";
        assertThat(RacingCarUtil.isValidNameInput(RacingCarUtil.splitIntoNames(input))).isTrue();
    }

    @Test
    void 공백처리_예외() {
        String input = "p obi, crong, ho  x";
        assertThat(RacingCarUtil.isValidNameInput(RacingCarUtil.splitIntoNames(input)))
            .isFalse();
    }

    @Test
    void 이름_중복_입력() {
        String input = "pobi, pobi";
        assertThat(RacingCarUtil.isValidNameInput(RacingCarUtil.splitIntoNames(input)))
            .isFalse();
        input = "pobi, pobi, pobi";
        assertThat(RacingCarUtil.isValidNameInput(RacingCarUtil.splitIntoNames(input)))
            .isFalse();
    }
}