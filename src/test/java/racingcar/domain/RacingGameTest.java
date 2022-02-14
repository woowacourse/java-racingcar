package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.MockRandomNumberGenerator;
import racingcar.RacingGame;
import racingcar.exception.GetWinnersBeforeFinishException;
import racingcar.exception.RacingGameIsFinishedException;
import racingcar.domain.result.MidtermResult;

public class RacingGameTest {

    private static final String CAR_1_NAME = "pobi";
    private static final String CAR_2_NAME = "jason";

    private RacingGame racingGame;
    private Car car1;
    private Car car2;

    @BeforeEach
    public void setUp() {
        car1 = Car.of(CAR_1_NAME);
        car2 = Car.of(CAR_2_NAME);
        racingGame = new RacingGame(new MockRandomNumberGenerator());
        racingGame.enrollCars(List.of(CAR_1_NAME, CAR_2_NAME));
    }

    @Test
    public void 시도횟수만큼_게임진행() {
        racingGame.initTryCount(2);
        assertThat(racingGame.isFinished()).isFalse();
        racingGame.proceedTurn();
        racingGame.proceedTurn();
        assertThat(racingGame.isFinished()).isTrue();
    }

    @Test
    public void 시도횟수_이상으로_게임_진행시_예외_발생() {
        racingGame.initTryCount(1);
        racingGame.proceedTurn();
        assertThatThrownBy(() -> racingGame.proceedTurn())
                .isInstanceOf(RacingGameIsFinishedException.class);
    }

    @Test
    public void 중간_실행결과_반환() {
        racingGame.initTryCount(1);
        racingGame.proceedTurn();
        MidtermResult result = racingGame.getMidtermResult();
        assertThat(result.getPositionByName(CAR_1_NAME)).isEqualTo(1);
        assertThat(result.getPositionByName(CAR_2_NAME)).isEqualTo(0);
    }

    @Test
    public void 단독우승자_조회() {
        racingGame.initTryCount(3);
        racingGame.proceedTurn();
        racingGame.proceedTurn();
        racingGame.proceedTurn();
        assertThat(racingGame.getWinnersResult().getWinnerNames()).contains(CAR_1_NAME);
    }

    @Test
    public void 공동우승자_조회() {
        racingGame.initTryCount(4);
        racingGame.proceedTurn();
        racingGame.proceedTurn();
        racingGame.proceedTurn();
        racingGame.proceedTurn();
        assertThat(racingGame.getWinnersResult().getWinnerNames()).contains(CAR_1_NAME, CAR_2_NAME);
    }

    @Test
    public void 게임_종료전에_우승자_반환시_예외_발생() {
        racingGame.initTryCount(1);
        assertThatThrownBy(() -> racingGame.getWinnersResult())
                .isInstanceOf(GetWinnersBeforeFinishException.class);
    }
}
