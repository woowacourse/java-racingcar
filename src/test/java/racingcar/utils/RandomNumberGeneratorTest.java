package racingcar.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @RepeatedTest(100)
    @DisplayName("랜덤값이 정해진 범위에서 생성되는지 테스트")
    void makeRandom() {
        int random = RandomNumberGenerator.makeRandom(10);
        Assertions.assertThat(random).isLessThan(10).isGreaterThanOrEqualTo(0);
    }
}