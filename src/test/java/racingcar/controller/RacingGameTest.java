package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@DisplayName("RacingGame 클래스를 테스트한다.")
class RacingGameTest {

    @Test
    @DisplayName("게임이 정상적으로 실행되는지 확인한다")
    void runGame() {
        final RacingGame racingGame = mock(RacingGame.class);

        InputStream nameInput = new ByteArrayInputStream("pobi,crong,honux".getBytes());
        InputStream repeatsInput = new ByteArrayInputStream("5".getBytes());
        System.setIn(nameInput);
        System.setIn(repeatsInput);
        racingGame.startGame();

        verify(racingGame).startGame();
    }
}