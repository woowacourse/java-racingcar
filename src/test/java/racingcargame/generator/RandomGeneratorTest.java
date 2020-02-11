package racingcargame.generator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcargame.genrator.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {
    @Test
    void 랜덤한_값을_생성한다() {
        Assertions.assertThat(RandomGenerator.generateRandom()).isLessThanOrEqualTo(9);
        assertThat(RandomGenerator.generateRandom()).isGreaterThanOrEqualTo(0);
    }
}
