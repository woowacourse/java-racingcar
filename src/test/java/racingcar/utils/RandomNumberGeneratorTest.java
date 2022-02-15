package racingcar.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class RandomNumberGeneratorTest {

    @Test
    void 랜덤_넘버_생성_확인() {
        int randomNumber = RandomNumberGenerator.pickRandomNumber();
        assertThat(randomNumber)
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}
