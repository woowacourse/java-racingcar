package application.racing;

import application.racing.domain.Cars;
import application.racing.domain.RacingGame;
import application.racing.domain.RacingLab;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    @DisplayName("RacingLab 만큼 게임이 실행되었는지 확인하는 메소드 테스트")
    @Test
    public void gameTest() {
        Cars cars = new Cars("lavin,pobi");
        RacingLab racingLab = new RacingLab("5");
        RacingGame racingGame = new RacingGame();

        for (int i = 0; i < 5; i++) {
            racingGame.raceOneLab(cars);
        }
        Assertions.assertThat(racingGame.isEnd(racingLab)).isTrue();
    }
}
