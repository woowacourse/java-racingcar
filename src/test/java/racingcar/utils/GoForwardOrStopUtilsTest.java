package racingcar.utils;


import static racingcar.utils.GoForwardOrStopUtils.MIN_GO_FORWARD_VALUE;
import static racingcar.utils.randomnumber.RandomNumbersGeneratorUtils.MAX_RANDOM_NUMBER;
import static racingcar.utils.randomnumber.RandomNumbersGeneratorUtils.MIN_RANDOM_NUMBER;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.GoForwardOrStopUtils;

class GoForwardOrStopUtilsTest {

    @DisplayName("4 이상의 수이면 true 반환, 아니면 false 반환")
    @Test
    void goForwardOrStop() {
        for (int i = MIN_RANDOM_NUMBER; i <= MAX_RANDOM_NUMBER; i++) {
            assertGoForwardOrStop(i);
        }
    }

    private void assertGoForwardOrStop(int number) {
        if (MIN_GO_FORWARD_VALUE <= number) {
            Assertions.assertThat(GoForwardOrStopUtils.isGoForward(number)).isTrue();
            return;
        }
        Assertions.assertThat(GoForwardOrStopUtils.isGoForward(number)).isFalse();
    }
}