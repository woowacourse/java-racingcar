package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GoOrStopTest {
    @Test
    void 랜덤하게_생성된_숫자가_0이상_9이하의_정수인지_검증() {
        assertThat(GoOrStop.generateRandomNumber()).isBetween(0,9);
        assertThat(5).isBetween(0,9);
    }
}
