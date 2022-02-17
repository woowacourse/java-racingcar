package racingcar.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Trial;
import static org.assertj.core.api.Assertions.*;

class TrialTest {

    @Test
    @DisplayName("시도횟수가 1보다 작을 경우 예외를 발생한다")
    void trial_negative() {
        assertThatThrownBy(() -> Trial.create(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도횟수를 감소한다")
    void minus_trial() {
        Trial trial = Trial.create(3);
        trial.minus();
        trial.minus();

        assertThat(trial.getTrial()).isEqualTo(1);
    }

    @Test
    @DisplayName("시도횟수 감소는 음수가 될 수 없다")
    void minus_trial_negative() {
        Trial trial = Trial.create(1);
        trial.minus();
        trial.minus();

        assertThat(trial.getTrial()).isEqualTo(0);
    }

    @Test
    @DisplayName("시도횟수가 1이라면 횟수가 남아있다")
    void exist_trial() {
        Trial trial = Trial.create(1);

        assertThat(trial.isExistsTrial()).isTrue();
    }

    @Test
    @DisplayName("시도횟수가 0이라면 더 이상 횟수가 없다")
    void notExist_trial() {
        Trial trial = Trial.create(1);
        trial.minus();

        assertThat(trial.isExistsTrial()).isFalse();
    }
}