package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("게임 생성에서")
class GameTest {
    @Test
    @DisplayName("시도할 횟수를 변환하여 게임을 생성한다")
    public void createGameTest() {
        //given
        String userTryCount = "5";

        //when&then
        assertDoesNotThrow(() -> Game.from(userTryCount));
    }
}