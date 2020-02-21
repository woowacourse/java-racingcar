package racingcargame.domain;

import org.junit.jupiter.api.Test;
import racingcargame.util.RandomFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomFactoryTest {
    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 엔진_값_생성_테스트() {
        for (int i = 0; i < 100; i++) {
            assertThat(RandomFactory.getRandom()).isBetween(0, 9);
        }
    }
}
