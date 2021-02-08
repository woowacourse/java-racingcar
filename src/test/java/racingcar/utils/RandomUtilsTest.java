package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RandomUtilsTest {

    @Test
    public void 랜덤값의_범위_테스트_negative() {
        // given, when, then
        assertThatThrownBy(() -> RandomUtils.nextInt(9, 1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 랜덤값의_시작_범위_테스트_negative() {
        // given, when, then
        assertThatThrownBy(() -> RandomUtils.nextInt(-1, 3))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @RepeatedTest(10)
    public void 랜덤값의_범위_테스트() {
        // given, when
        int start = 0;
        int end = 9;

        // then
        assertThat(RandomUtils.nextInt(start, end)).isBetween(start, end);
    }

}