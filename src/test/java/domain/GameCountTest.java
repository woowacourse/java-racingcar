package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("게임 카운트")
class GameCountTest {

    @DisplayName("1 ~ 100 사이의 값이 들어왔을 때")
    @ParameterizedTest
    @ValueSource(strings = {"1", "100", "34"})
    void validateRangeOfNumberOfTimesSuccess(String input) {
        assertDoesNotThrow(() -> new GameCount(input));
    }

    @DisplayName("1 ~ 100 이외의 값이 들어왔을 때")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "101"})
    void validateRangeOfNumberOfTimesFail(String input) {
        assertThatThrownBy(() -> new GameCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 ~ 100 사이의 숫자를 입력해주세요");
    }

    @DisplayName("정수가 아닌 값이 들어왔을 때")
    @ParameterizedTest
    @ValueSource(strings = {"2.8", "sldlfks"})
    void validateNumberOfTimesIsNotInteger(String input) {
        assertThatThrownBy(() -> new GameCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("0 이 아닐 때 게임이 진행중임을 확인")
    void isGameOverFalse() {
        GameCount gameCount = new GameCount("1");
        assertThat(gameCount.isGameProgress())
                .isTrue();
    }

    @Test
    @DisplayName("0 일 때 게임이 종료됨을 확인")
    void isGameOverTrue() {
        GameCount gameCount = new GameCount("1");
        gameCount.proceedOnce();
        assertThat(gameCount.isGameProgress())
                .isFalse();
    }

    @Test
    @DisplayName("감소")
    void proceedOnce() {
        GameCount gameCount = new GameCount("1");
        gameCount.proceedOnce();
        assertThat(gameCount.isGameProgress())
                .isFalse();
    }

    @Test
    @DisplayName("게임 횟수 이상으로 진행할 때")
    void proceedOnceFail() {
        GameCount gameCount = new GameCount("1");
        gameCount.proceedOnce();
        assertThatThrownBy(gameCount::proceedOnce)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임은 횟수만큼만 진행해야합니다.");
    }

}
