package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {
    @Test
    void 랜덤값_0에서_9까지_생성_테스트() {
        assertThat(Random.createRandomValue()).isBetween(0, 9);
    }
}
