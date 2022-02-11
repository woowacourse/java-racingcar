package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    public static final int FIRST_TRY_NUMBER = 0;
    public static final int LAST_TRY_NUMBER = 100;
    public static final int MAX_LIMIT = 9;

    @DisplayName("0~9까지 랜덤한 숫자가 정상적으로 생성되는지 테스트")
    @Test
    void generate() {
        for (int i = FIRST_TRY_NUMBER; i < LAST_TRY_NUMBER; i++) {
            int value = RandomNumberGenerator.generate();
            Assertions.assertThat(value).isNotNegative()
                .isLessThanOrEqualTo(MAX_LIMIT);
        }
    }
}
