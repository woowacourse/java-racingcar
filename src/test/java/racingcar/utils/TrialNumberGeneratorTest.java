package racingcar.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.utils.generator.TrialNumberGenerator;

public class TrialNumberGeneratorTest {
    @Test
    void 시도횟수_정상입력() {
        assertThat(TrialNumberGenerator.generateTrialNumber("3")).isEqualTo(3);
    }
}
