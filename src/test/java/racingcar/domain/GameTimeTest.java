package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Objects;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTimeTest {

    @ParameterizedTest
    @DisplayName("시도 횟수 예외 입력 테스트")
    @ValueSource(strings = {"500", "501", "-1", "숫자아님"})
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

    @Test
    @DisplayName("gameTime이 timeSpent와 같을 때 isPlayable이 false를 반환한다.")
    void isPlayableFalseTest() {
        GameTime gameTime = new GameTime("1");

        gameTime.runOnce();

        assertThat(gameTime.isPlayable())
                .isFalse();
    }

    @Test
    @DisplayName("gameTime이 timeSpent와 다를 때 isPlayable이 true를 반환한다.")
    void isPlayableTrueTest() {
        GameTime gameTime = new GameTime("2");

        gameTime.runOnce();

        assertThat(gameTime.isPlayable())
                .isTrue();
    }
}
