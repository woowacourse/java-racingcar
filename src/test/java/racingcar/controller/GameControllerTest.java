package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class GameControllerTest {

    private final static GameController gameController = new GameController();

    @Test
    void 자동차_이름_입력() {
        String input = "aa,bb,cc";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(gameController.createCarNames()).containsExactly("aa", "bb", "cc");
    }

    @Test
    void 시도_횟수_입력() {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(gameController.createTryCount()).isEqualTo(5);
    }
}
