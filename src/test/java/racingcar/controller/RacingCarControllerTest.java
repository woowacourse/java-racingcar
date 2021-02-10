package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarControllerTest {
    private static final String INTEGER_TURN_MESSAGE = "[ERROR] 시도 횟수는 정수여야만 합니다";
    private static final String NEGATIVE_TURN_MESSAGE = "[ERROR] 시도 횟수는 음수일 수 없습니다";
    private static final String MINUS_TURN_SAMPLE = "-1";
    private static final String VOID_SAMPLE = "";

    @Test
    @DisplayName("시도횟수가 정수인지 확인")
    void checkInteger() {
        String turns = VOID_SAMPLE;
        assertThatThrownBy(() -> {
            RacingCarController.checkTurns(turns);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INTEGER_TURN_MESSAGE);
    }

    @Test
    @DisplayName("시도횟수가 음수인지 확인")
    void checkNegative() {
        String turns = MINUS_TURN_SAMPLE;
        assertThatThrownBy(() -> {
            RacingCarController.checkTurns(turns);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NEGATIVE_TURN_MESSAGE);
    }
}
