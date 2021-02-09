package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarGameTest {
    @DisplayName("laps: 음수나 숫자아닌 값 입력 예외테스트")
    @ParameterizedTest
    @CsvSource(value = {"-1", "asdf" })
    void racing(String value) {
        RacingCarGame racingCarGame = new RacingCarGame();

        assertThatThrownBy(() -> {
            racingCarGame.validateLaps(value);
        }).isInstanceOf(RuntimeException.class);
    }
}
