package com.woowacourse.javaracingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RacingCarUtilTest {
    @Test
    void 정상이름_입력() {
        String input = "pobi,crong,honux";
        assertThat(RacingcarUtil.isValidNameInput(RacingcarUtil.splitIntoNames(input))).isTrue();
    }

    @Test
    void 비정상_이름_입력_5자초과() {
        String input = "pobi,crong,honuxxx";

        assertThat(RacingcarUtil.isValidNameInput(RacingcarUtil.splitIntoNames(input)))
            .isFalse();
    }

    @Test
    void 비정상_이름_입력() {
        String input = ", ";
        assertThat(RacingcarUtil.isValidNameInput(RacingcarUtil.splitIntoNames(input)))
            .isFalse();
    }

    @Test
    void 정상이름_입력_공백처리() {
        String input = "pobi   ,  crong,  honux   ";
        assertThat(RacingcarUtil.isValidNameInput(RacingcarUtil.splitIntoNames(input))).isTrue();
    }

    @Test
    void 공백처리_예외() {
        String input = "p obi, crong, ho  x";
        assertThat(RacingcarUtil.isValidNameInput(RacingcarUtil.splitIntoNames(input)))
            .isFalse();
    }

    @Test
    void 이름_중복_입력() {
        String input = "pobi, pobi";
        assertThat(RacingcarUtil.isValidNameInput(RacingcarUtil.splitIntoNames(input)))
            .isFalse();
        input = "pobi, pobi, pobi";
        assertThat(RacingcarUtil.isValidNameInput(RacingcarUtil.splitIntoNames(input)))
            .isFalse();
    }
}