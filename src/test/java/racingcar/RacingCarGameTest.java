package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarGameTest {

    @ParameterizedTest
    @CsvSource(value = {"-1", "asdf" })
    void racing(String value) {
        RacingCarGame racingCarGame = new RacingCarGame();
        assertThatThrownBy(() -> {
            racingCarGame.validateLaps(value);
        }).isInstanceOf(RuntimeException.class);
    }
}
