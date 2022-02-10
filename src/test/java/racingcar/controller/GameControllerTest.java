package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GameControllerTest {
    private static GameController gameController;

    @BeforeAll
    static void initAll() {
        gameController = new GameController();
    }

    @Test
    void 자동차_이름_입력() {
        String input = "aa, bb, cc";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(gameController.createCarNames()).containsExactly("aa", "bb", "cc");
    }
}