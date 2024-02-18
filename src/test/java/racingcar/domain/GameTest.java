package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("게임 생성에서")
class GameTest {
    @Test
    @DisplayName("시도할 횟수를 변환하여 게임을 생성한다")
    public void createGameTest() {
        //given
        String userCarNames = "choco,seyan";
        String userTryCount = "5";

        //when&then
        assertDoesNotThrow(() -> Game.from(userTryCount, Cars.from(userCarNames)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "1.5", "", " ", "1 2"})
    @NullSource
    @DisplayName("시도할 횟수가 자연수가 아닐 경우 예외가 발생한다")
    public void nonNaturalNumberTest(String userTryCount) {
        //given
        String userCarNames = "choco,seyan";

        //when & then
        assertThrows(NumberFormatException.class, () -> Game.from(userTryCount, Cars.from(userCarNames)));
    }

    @Test
    @DisplayName("게임의 진행은 오류 없이 진행된다.")
    public void runProceed() {
        //given
        String userCarNames = "choco,seyan";
        Game game = Game.from("5", Cars.from(userCarNames));

        //when&then
        assertThatCode(game::proceed).doesNotThrowAnyException();
    }
}