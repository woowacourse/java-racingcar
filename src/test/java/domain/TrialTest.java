package domain;

import exception.NegativeTrialException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrialTest {
    @Test
    void 생성자_음인_입력() {
        assertThrows(NegativeTrialException.class, () -> Trial.from(-1));
    }

    @Test
    void adjust_() {
        int numTrial = 1;
        Trial trial = Trial.from(numTrial);

        assertThat(trial.adjust()).isEqualTo(Trial.from(numTrial - 1));
    }

    @Test
    void isEmpty() {
        Trial emptyTrial = Trial.from(0);

        assertThat(emptyTrial.isEmpty()).isTrue();
    }
}
