package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LapTest {
    @DisplayName("시도 횟수 입력으로 숫자 형식이 아닌 입력이 들어왔을 때 예외 발생")
    @Test
    void Should_ThrowException_When_LapIsNotNumeric() {
        String lapInput = "문자열";

        Assertions.assertThrows(NumberFormatException.class, () -> {
            new Lap(lapInput);
        });
    }

    @DisplayName("시도 횟수 입력으로 숫자 형식의 입력이 들어왔을 때 예외 미발생")
    @Test
    void Should_NotThrowException_When_LapIsNumeric() {
        String lapInput = "5";

        assertDoesNotThrow(() -> new Lap(lapInput));
    }

    @DisplayName("시도 횟수 입력이 최소 횟수인 1보다 작을 때 예외 발생")
    @Test
    void Should_ThrowException_When_LapIsLessThanOne() {
        String lapInput = "0";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Lap(lapInput);
        });
    }

    @DisplayName("시도 횟수 입력이 최소 횟수인 1 이상일 때 예외 미발생")
    @Test
    void Should_NotThrowException_When_LapIsNotLessThanOne() {
        String lapInput = "1";

        assertDoesNotThrow(() -> new Lap(lapInput));
    }

    @DisplayName("시도 횟수 차감")
    @Test
    void Should_EqualToExpected_When_LapIsDecremented() {
        Lap lap = new Lap("4");
        Lap expectedLapAfterDecrement = new Lap("2");

        lap.decrement();
        lap.decrement();

        assertEquals(lap, expectedLapAfterDecrement);
    }

    @DisplayName("시도 횟수 0")
    @Test
    void Should_True_When_LapIsZero() {
        Lap lap = new Lap("1");

        lap.decrement();

        assertThat(lap.isZero()).isTrue();
    }
}