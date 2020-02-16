package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundTest {

    @ParameterizedTest
    @CsvSource(value = {"-1", "0"})
    @DisplayName("라운드 입력 유효성 검사")
    void validateRound(int round) {
        assertThatThrownBy(() -> Round.validateRound(round))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
