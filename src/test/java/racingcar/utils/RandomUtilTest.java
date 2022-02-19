package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomUtilTest {

    private static final int INCLUSIVE_RANGE_START = 0;
    private static final int EXCLUSIVE_RANGE_END = 3;

    @DisplayName("지정된 범위 내 랜덤 값 선정 기능 테스트")
    @RepeatedTest(value = 20)
    void pickNumberInRangeTest() {
        final int randomNumber = RandomUtil.pickNumberInRange(INCLUSIVE_RANGE_START, EXCLUSIVE_RANGE_END);
        assertThat(randomNumber).isBetween(INCLUSIVE_RANGE_START, EXCLUSIVE_RANGE_END - 1);
    }

}
