package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AttemptTest {

    @Test
    @DisplayName("시도 횟수에 음수를 입력한 경우 예외 발생")
    void attemptMustBePositive() {
        assertThatThrownBy(() -> new Attempt(-3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("실행이 모두 끝나면 종료임을 반환")
    void isOver() {
        Attempt attempt = new Attempt(1);
        attempt.endTurn();

        assertThat(attempt.isOver()).isTrue();
    }

    @Test
    @DisplayName("실행이 모두 끝나지 않으면 종료가 아님을 반환")
    void isNotOver() {
        Attempt attempt = new Attempt(2);
        attempt.endTurn();

        assertThat(attempt.isOver()).isFalse();
    }
}
