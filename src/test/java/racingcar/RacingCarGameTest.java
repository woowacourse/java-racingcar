package racingcar;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Cars;
import racingcar.domain.RacingCarGame;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarGameTest {
    @DisplayName("laps: 음수나 숫자아닌 값 입력 예외테스트")
    @ParameterizedTest
    @CsvSource(value = {"-1", "asdf"})
    void racing(String value) {
        assertThatThrownBy(() -> {
            new RacingCarGame(Arrays.asList("pobi", "crong"), value);
        }).isInstanceOf(RuntimeException.class);
    }

}
