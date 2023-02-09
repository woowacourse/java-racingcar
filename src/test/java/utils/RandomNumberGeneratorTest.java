package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {

    @RepeatedTest(100)
    void 랜덤한_0에서_9사이의_숫자를_생성() {
        //given
        final int MIN = 0;
        final int MAX = 9;
        //when
        int randomNumber = RandomNumberGenerator.generateNumber();
        //then
        Assertions.assertThat(randomNumber).isBetween(MIN, MAX);
    }
}