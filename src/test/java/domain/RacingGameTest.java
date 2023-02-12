package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import validation.ErrorMessage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        racingGame = new RacingGame(new Cars(List.of(car1, car2, car3)), 3, new RandomNumberGenerator());
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 0})
    @DisplayName("최소 게임 횟수보다 작은 횟수인 경우 예외가 발생한다")
    public void createRacingGameFail(int gameTrialCount) {
        assertThatThrownBy(() ->
                new RacingGame(new Cars(List.of(car1, car2, car3)), gameTrialCount, new RandomNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.WRONG_TRIAL_NUMBER.getMessage());
    }

    @Test
    @DisplayName("남은 게임 횟수가 1보다 큰 경우 게임을 지속한다.")
    public void checkGameContinueCondition() {
        racingGame.run();
        racingGame.run();

        assertThat(racingGame.canContinue()).isTrue();
    }

    @Test
    @DisplayName("남은 게임 횟수가 1보다 작은 경우 게임을 종료한다.")
    public void checkGameFinishCondition() {
        racingGame.run();
        racingGame.run();
        racingGame.run();

        assertThat(racingGame.canContinue()).isFalse();
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
    @DisplayName("가장 선두에 여러명인 경우, 공동 우승자가 발생한다.")
    public void findAllWinners() {
        car1.move();
        car2.move();
        car3.move();

        assertThat(racingGame.getWinners().size()).isEqualTo(3);
    }
}
