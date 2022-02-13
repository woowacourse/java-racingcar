package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomIntegerGeneratorTest {

    @Test
    @DisplayName("랜덤 값이 지정한 범위 이내인지 확인 - 범위")
    void checkRange_range() {
        assertThat(RandomIntegerGenerator.random(0, 9)).isBetween(0, 9);
    }

    @Test
    @DisplayName("랜덤 값이 지정한 범위 이내인지 확인 - 단일값")
    void checkRange_single() {
        assertThat(RandomIntegerGenerator.random(3, 3)).isEqualTo(3);
    }
}
