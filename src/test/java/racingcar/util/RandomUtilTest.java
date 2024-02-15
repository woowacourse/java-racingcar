package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("랜덤")
class RandomUtilTest {
    @Test
    @DisplayName("값의 최소와 최대 범위를 제한한다.")
    public void testRandomBetween() {
        //given
        int minLimit = 0;
        int maxLimit = 9;

        //when
        int randomNumber = RandomUtil.pickRandomNumber(minLimit, maxLimit);

        //then
        assertThat(randomNumber).isBetween(minLimit, maxLimit);
    }

    @Test
    @DisplayName("입력된 최소값이 최대값 보다 클 경우 예외가 발생한다.")
    public void verifyMaxLimitGreaterThanMinLimit() {
        //given
        int minLimit = 5;
        int maxLimit = 4;

        //when & then
        assertThatThrownBy(() -> RandomUtil.pickRandomNumber(minLimit, maxLimit))
                .isInstanceOf(IllegalStateException.class);
    }
}