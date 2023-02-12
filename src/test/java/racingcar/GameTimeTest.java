package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.GameTime;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTimeTest {

    @ParameterizedTest
    @DisplayName("시도 횟수 예외 입력 테스트")
    @ValueSource(strings = {"501", "-1", "숫자아님"})
    void initTest(String param) {
        assertThatThrownBy(() -> new GameTime(param))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "499"})
    @DisplayName("정상 입력 확인")
    void notExceptionCase(String param) {
        assertThatCode(() -> new GameTime(param))
                .doesNotThrowAnyException();
    }
}