package controller;

import domain.Service;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ControllerTest {
    Controller controller = new Controller(new Service());

    @DisplayName("시도횟수가 1이상이 아닌 경우 예외가 발생한다")
    @Test
    void validateNumberTest() {
        Assertions.assertThatThrownBy(() -> controller.validateNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수");
    }

    @DisplayName("시도횟수가 정수가 아닌 경우 예외가 발생한다")
    @Test
    void validateInputAttemptLimitTest() {
        Assertions.assertThatThrownBy(() -> controller.validateInputAttemptLimit("1.2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수");
    }
}
