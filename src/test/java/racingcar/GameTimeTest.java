package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTimeTest {

    @ParameterizedTest
    @ValueSource(strings = {"501", "-1", "숫자아님"})
    void initTest(String param) {
        assertThatThrownBy(() -> new GameTime(param))
                .isInstanceOf(IllegalArgumentException.class);
    }
}