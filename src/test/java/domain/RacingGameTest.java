package domain;

import domain.numbergenerator.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private Car car1;
    private Car car2;
    private Car car3;
    private RacingGame racingGame;


    @BeforeEach
    public void init() {
        car1 = new Car("kong");
        car2 = new Car("gray");
        car3 = new Car("echo");
        racingGame = new RacingGame(List.of(car1, car2, car3), new GameTrialCount("3"), new RandomNumberGenerator());
    }

    @Test
    @DisplayName("가장 선두에 있는 차가 우승자이다.")
    public void findWinner() {
        car3.move();
        car3.move();
        car3.move();

        assertThat(racingGame.getWinners().contains(car1)).isFalse();
        assertThat(racingGame.getWinners().contains(car2)).isFalse();
        assertThat(racingGame.getWinners().contains(car3)).isTrue();
    }

    @Test
    @DisplayName("남은 게임 횟수가 1보다 큰 경우 게임을 지속한다.")
    public void checkGameContinueCondition() {
        racingGame.run();
        racingGame.run();

        assertThat(racingGame.canContinue()).isTrue();
    }

    @Test
    @DisplayName("남은 게임 횟수가 1보다 큰 경우 게임을 지속한다.")
    public void checkGameFinishCondition() {
        racingGame.run();
        racingGame.run();
        racingGame.run();

        assertThat(racingGame.canContinue()).isFalse();
    }

}