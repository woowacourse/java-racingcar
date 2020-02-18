package domain;

import calculator.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AttemptNumberTest {
    @Test
    void createAttemptNumber_적합한_횟수() {
        new AttemptNumber("1");
    }

    @Test
    void createAttemptNumber_부적합한_횟수_문자() {
        assertThatThrownBy(() -> new AttemptNumber("타미"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createAttemptNumber_부적합한_횟수_음수() {
        assertThatThrownBy(() -> new AttemptNumber("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void reduce() {
        AttemptNumber attemptNumber = new AttemptNumber("1");
        assertThat(attemptNumber.reduce()).isTrue();
        assertThat(attemptNumber.reduce()).isFalse();
    }

    @Test
    void isEnd() {
        AttemptNumber attemptNumber = new AttemptNumber("1");
        assertThat(attemptNumber.isEnd()).isFalse();

        attemptNumber.reduce();
        assertThat(attemptNumber.isEnd()).isTrue();
    }
}
