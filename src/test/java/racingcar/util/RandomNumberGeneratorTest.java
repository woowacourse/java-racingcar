package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class RandomNumberGeneratorTest {
    @Test
    public void 랜덤값_범위_테스트() {
        int number = new BoundedRandomNumberGenerator(9, 0).generate();
        assertThat(0 <= number && number <= 9).isEqualTo(true);
    }
}