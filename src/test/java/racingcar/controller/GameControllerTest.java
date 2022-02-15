package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameControllerTest {

    private final static GameController gameController = new GameController();

    @Test
    @DisplayName("자동차 이름 입력 테스트")
    void inputCarNames() {
        String input = "aa,bb,cc";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(gameController.inputCarNames()).containsExactly("aa", "bb", "cc");
    }

    @Test
    @DisplayName("시도 횟수 입력 테스트")
    void inputTryCount() {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(gameController.inputTryCount()).isEqualTo(5);
    }
}
