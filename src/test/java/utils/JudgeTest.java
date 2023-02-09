package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class JudgeTest {

    @DisplayName("4이상의 숫자에 대해 참을 반환해야함")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    void able(int number) {
        //given
        //when
        boolean judgeResult = Judge.isAble(number);
        //then
        Assertions.assertThat(judgeResult).isTrue();
    }

    @DisplayName("4미만의 숫자에 대해 거짓을 반환해야함")
    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest
    void disable(int number) {
        //given
        //when
        boolean judgeResult = Judge.isAble(number);
        //then
        Assertions.assertThat(judgeResult).isFalse();
    }

}