package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AttemptTest {

    @DisplayName("시도횟수 공백 테스트")
    @Test
    void attempt_empty() {
        assertThatThrownBy(() -> {
            Attempt attempt = new Attempt(" ");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도횟수 null 테스트")
    @Test
    void attempt_null() {
        assertThatThrownBy(() -> {
            Attempt attempt = new Attempt(null);
        }).isInstanceOf(NullPointerException.class);
    }

    @DisplayName("시도횟수 문자 예외 테스트")
    @Test
    void attempt_number() {
        assertThatThrownBy(() -> {
            Attempt attempt = new Attempt("횟수");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도횟수 문자열 음수 테스트")
    @Test
    void attempt_string_negative() {
        assertThatThrownBy(() -> {
            Attempt attempt = new Attempt("-1");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도횟수 음수 테스트")
    @Test
    void attempt_negative() {
        assertThatThrownBy(() -> {
            Attempt attempt = new Attempt(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("같은 숫자 테스트")
    @Test
    void attempt_equals() {
        Attempt attempt = new Attempt(5);
        assertTrue(attempt.isSame(5));
    }
}