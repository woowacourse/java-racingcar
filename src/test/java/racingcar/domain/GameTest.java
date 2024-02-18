package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("게임")
class GameTest {
    @Test
    @DisplayName("생성한다")
    public void createGameTest() {
        //given
        List<String> userCarNames = List.of("choco", "seyan");
        int userTryCount = 5;

        //when&then
        assertDoesNotThrow(() -> new Game(TryCount.from(userTryCount), Cars.from(userCarNames)));
    }

    @Test
    @DisplayName("진행은 오류 없이 진행된다.")
    public void runProceed() {
        //given
        List<String> userCarNames = List.of("choco", "seyan");
        int userTryCount = 5;

        Game game = new Game(TryCount.from(userTryCount), Cars.from(userCarNames));

        //when&then
        assertThatCode(game::proceed).doesNotThrowAnyException();
    }
}