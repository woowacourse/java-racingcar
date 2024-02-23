package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("시도 횟수 테스트")
public class AttemptsTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    @DisplayName("정상적인 시도 횟수인가")
    void valid_attempts_number_test(int numberOfAttempts) {
        assertThatCode(() -> new Attempts(numberOfAttempts))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, 0, 11})
    @DisplayName("비정상적인 시도 횟수인가")
    void invalid_attempts_number_test(int numberOfAttempts) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Attempts(numberOfAttempts));
    }

    @Test
    @DisplayName("시도 횟수가 정상적으로 감소하는가")
    void valid_attempts_decrease_test() {
        // given
        Attempts attempts = new Attempts(9);

        // when
        attempts.decrease();

        // then
        assertThat(attempts).isEqualTo(new Attempts(8));
    }

    @Test
    @DisplayName("시도가 종료됐는가")
    void is_attempts_ended_test() {
        // given
        Attempts attempts = new Attempts(9);

        // when
        for (int i = 0; i < 9; i++) {
            attempts.decrease();
        }

        // then
        assertThat(attempts.isEnd()).isTrue();
    }

    @Test
    @DisplayName("시도가 종료되지 않았는가")
    void is_attempts_not_ended_test() {
        // given
        Attempts attempts = new Attempts(9);

        // when
        attempts.decrease();

        // then
        assertThat(attempts.isEnd()).isFalse();
    }

}
