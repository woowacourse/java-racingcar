package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.util.BoundedRandomNumberGenerator;

@SuppressWarnings("NonAsciiCharacters")
public class RandomNumberGeneratorTest {
    private BoundedRandomNumberGenerator randomNumberGenerator
            = new BoundedRandomNumberGenerator(9, 0);

    @Test
    public void 랜덤값_범위_테스트() {
        int number = randomNumberGenerator.generate();
        assertThat(0 <= number && number <= 9).isEqualTo(true);
    }

}
