package racingcargame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomEngineTest {

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 엔진_랜덤_생성_테스트() {
        RandomEngine randomEngine = new RandomEngine();
        for (int i = 0; i < 100; i++) {
            assertThat(randomEngine.getPower()).isBetween(0, 9);
        }
    }
}
