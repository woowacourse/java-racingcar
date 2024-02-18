package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundTest {

    @Test
    @DisplayName("시도 횟수 정상 입력")
    void round_ok() {
        Assertions.assertAll(
            () -> new Round("1"),
            () -> new Round("100")
        );
    }

    @Test
    @DisplayName("시도 횟수 예외 입력: 범위 초과")
    void round_exception_rangeViolation() {
        Assertions.assertAll(
            () -> assertThatThrownBy(() -> new Round("-1"))
                .isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new Round("0"))
                .isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new Round("101"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수 예외 입력: 숫자가 아닌 입력")
    void round_exception_nonNumbers() {
        Assertions.assertAll(
            () -> assertThatThrownBy(() -> new Round("abc"))
                .isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new Round("10!"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
