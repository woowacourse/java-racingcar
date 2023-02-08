package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomMakerTest {

    @Test
    @DisplayName("랜덤값 범위가 0~9인지 확인하기")
    void random() {
        int actual = RandomMaker.random();

        assertThat(actual).isGreaterThan(-1).isLessThan(10);
    }
}