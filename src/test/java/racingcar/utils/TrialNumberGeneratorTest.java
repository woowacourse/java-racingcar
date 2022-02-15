package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrialNumberGeneratorTest {
    @Test
    void 시도횟수_정상입력() {
        assertThat(TrialNumberGenerator.generateTrialNumber("3")).isEqualTo(3);
    }
}
