package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.utils.Validator;

public class Count {
    @Test
    void 횟수_입력값이_1미만인_경우() {
        final int correctCount = 0;

        assertThatThrownBy(() -> Validator.checkCount(countString))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("1 이상");
    }

    @Test
    void 횟수_입력값이_50초과인_경우() {
        final int correctCount = "51";

        assertThatThrownBy(() -> Validator.checkCount(countString))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("50 이하");
    }
}
