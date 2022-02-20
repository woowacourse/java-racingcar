package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.exception.GetWinnerBeforeFinishException;
import racingcar.domain.exception.RacingGameIsFinishedException;
import racingcar.domain.game.RacingGame;
import racingcar.domain.result.MidtermResult;
import racingcar.domain.result.WinnerResult;

public class RacingGameTest {

    private static final String CAR_1_NAME = "pobi";
    private static final String CAR_2_NAME = "jason";

    @Test
    public void 시도횟수만큼_게임진행() {
        RacingGame racingGame = new RacingGame(2, List.of(CAR_1_NAME, CAR_2_NAME),
            new MockRandomNumberGenerator());
        assertThat(racingGame.isFinished()).isFalse();
        racingGame.proceedTurn();
        racingGame.proceedTurn();
        assertThat(racingGame.isFinished()).isTrue();
    }

    @Test
    public void 단독우승자_조회() {
        RacingGame racingGame = new RacingGame(3, List.of(CAR_1_NAME, CAR_2_NAME),
            new MockRandomNumberGenerator());
        racingGame.proceedTurn();
        racingGame.proceedTurn();
        racingGame.proceedTurn();
        assertThat(racingGame.getWinnerResult().getWinnerNames()).contains(CAR_1_NAME);
    }

    @Test
    public void 우승자_조회() {
        RacingGame racingGame = new RacingGame(4, List.of(CAR_1_NAME, CAR_2_NAME),
            new MockRandomNumberGenerator());
        racingGame.proceedTurn();
        racingGame.proceedTurn();
        racingGame.proceedTurn();
        racingGame.proceedTurn();
        assertThat(racingGame.getWinnerResult().getWinnerNames()).contains(CAR_1_NAME, CAR_2_NAME);
    }

    @Test
    public void 시도횟수_이상으로_게임진행시_예외발생후_자동차_위치_미변경() {
        RacingGame racingGame = new RacingGame(1, List.of(CAR_1_NAME, CAR_2_NAME),
            new MockRandomNumberGenerator());
        racingGame.proceedTurn();
        MidtermResult prevResult = racingGame.getMidtermResult();

        assertThatThrownBy(() -> racingGame.proceedTurn())
            .isInstanceOf(RacingGameIsFinishedException.class);

        MidtermResult midtermResult = racingGame.getMidtermResult();
        assertThat(midtermResult.getPositionByName(CAR_1_NAME))
            .isEqualTo(prevResult.getPositionByName(CAR_1_NAME));
        assertThat(midtermResult.getPositionByName(CAR_2_NAME))
            .isEqualTo(prevResult.getPositionByName(CAR_2_NAME));
    }

    @Test
    public void 게임_종료전에_우승자_반환시_예외_발생() {
        RacingGame racingGame = new RacingGame(1, List.of(CAR_1_NAME, CAR_2_NAME),
            new MockRandomNumberGenerator());
        assertThatThrownBy(() -> racingGame.getWinnerResult())
            .isInstanceOf(GetWinnerBeforeFinishException.class);
    }

    @Test
    public void 중간_실행결과_반환() {
        RacingGame racingGame = new RacingGame(1, List.of(CAR_1_NAME, CAR_2_NAME),
            new MockRandomNumberGenerator());
        racingGame.proceedTurn();
        MidtermResult result = racingGame.getMidtermResult();
        assertThat(result.getPositionByName(CAR_1_NAME)).isEqualTo(1);
        assertThat(result.getPositionByName(CAR_2_NAME)).isEqualTo(0);
    }

    @Test
    public void 우승자_반환() {
        RacingGame racingGame = new RacingGame(1, List.of(CAR_1_NAME, CAR_2_NAME),
            new MockRandomNumberGenerator());
        racingGame.proceedTurn();
        WinnerResult result = racingGame.getWinnerResult();
        assertThat(result.getWinnerNames()).contains(CAR_1_NAME);
    }
}
