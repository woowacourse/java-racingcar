package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @DisplayName("자동차 이름이 하나일 경우, 그 차가 우승한다.")
    public void testGameOneWinner() {
        //given
        String userCarName = "choco";
        List<String> userCarNames = List.of(userCarName);
        int userTryCount = 5;

        //when
        Game game = new Game(TryCount.from(userTryCount), Cars.from(userCarNames));
        game.proceed();
        Winners winners = game.getWinners();

        //then
        assertEquals(winners.getWinners().size(), 1);
        assertEquals(winners.getWinners().get(0), userCarName);
    }

    @Test
    @DisplayName("여러 자동차 이름 중, 우승자를 반환한다.")
    public void testGameWinners() {
        //given
        String userCarName1 = "choco";
        String userCarName2 = "seyan";
        String userCarName3 = "clova";
        List<String> userCarNames = List.of(userCarName1, userCarName2, userCarName3);
        int userTryCount = 5;

        //when
        Game game = new Game(TryCount.from(userTryCount), Cars.from(userCarNames));
        game.proceed();
        Winners winners = game.getWinners();

        //then
        assertThat(winners.getWinners()).containsAnyOf(userCarName1, userCarName2, userCarName3);
    }
}