package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayTimeTest {

    @DisplayName("실행 횟수는 0이하보다 작을시 예외를 반환합니다.")
    @Test
    public void biggerThanZero() {
        assertThatThrownBy(() -> new PlayTime(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
