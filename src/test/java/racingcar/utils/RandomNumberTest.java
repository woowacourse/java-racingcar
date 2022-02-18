package racingcar.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class RandomNumberTest {

    @ParameterizedTest
    @CsvSource(value = "5,5")
    void 난수_항상_5_생성(int min, int max) {
        assertThat(generate(min, max)).isEqualTo(5);
    }

    private int generate(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
}