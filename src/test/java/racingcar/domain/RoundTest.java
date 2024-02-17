package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InvalidRoundFormatException;
import racingcar.exception.InvalidRoundRangeException;

class RoundTest {

    @DisplayName("라운드 값이 정수가 아니면 예외를 던진다")
    @ParameterizedTest
    @ValueSource(strings = {"조조는바보", "감자는멋져", "초코12", "sdfsd", " ", ""})
    void testRoundCountIsNotInteger(String roundCount) {
        assertThatThrownBy(() -> new Round(roundCount))
                .isInstanceOf(InvalidRoundFormatException.class);
    }

    @DisplayName("라운드 값이 1보다 작으면 예외를 던진다")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-2", "-3"})
    void testInvalidRoundCountRange(String roundCount) {
        assertThatThrownBy(() -> new Round(roundCount))
                .isInstanceOf(InvalidRoundRangeException.class);
    }

    @DisplayName("라운드 값이 1이상 정수이면 예외를 던지지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "100", "101"})
    void testValidRoundCount(String roundCount) {
        assertDoesNotThrow(() -> new Round(roundCount));
    }

    @DisplayName("라운드 값이 양수이면 isRemain()이 참을 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "100"})
    void testIsRemain(String roundCount) {
        Round round = new Round(roundCount);
        assertTrue(round.isRemain());
    }
}
