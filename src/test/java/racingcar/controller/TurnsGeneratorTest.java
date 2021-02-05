package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class TurnsGeneratorTest {

    private static final String INTEGER_TURN_MESSAGE = "[ERROR] 시도 횟수는 정수여야만 합니다.";
    private static final String NEGATIVE_TURN_MESSAGE = "[ERROR] 시도 횟수는 음수일 수 없습니다";
    private static final String MINUS_TURN_SAMPLE = "-1";
    private static final String VOID_SAMPLE = "";

    @Test
    void checkInteger() {
        assertThatThrownBy(() -> {
            TurnsGenerator.checkTurns(VOID_SAMPLE);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(INTEGER_TURN_MESSAGE);
    }

    @Test
    void checkNegative() {
        assertThatThrownBy(() -> {
            TurnsGenerator.checkTurns(MINUS_TURN_SAMPLE);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(NEGATIVE_TURN_MESSAGE);
    }
}
