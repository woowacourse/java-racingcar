package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LapTest {
    @Test
    void Should_ThrowException_When_LapIsString() {
        String lapInput = "문자열";

        assertThatThrownBy(() -> {
            new Lap(lapInput);
        }).isInstanceOf(NumberFormatException.class);
    }
}