package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.Rule.MoveRule;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingGameTest {
    @Test
    void 자동차들이_없는_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCars racingCars = new RacingCars();
            RacingGame.playRacingGame(racingCars, 1, new MoveRule());
        });
    }

    @Test
    void 시도_횟수가_최소값_미만인_경우() {
        RacingCars racingCars = new RacingCars();
        racingCars.add(new Car("pobi"));

        assertThrows(IllegalArgumentException.class, () -> {
            RacingGame.playRacingGame(racingCars, 0, new MoveRule());
        });
    }

    @Test
    void 시도_횟수만큼_게임이_진행되는지_확인() {
        String[] carNames = {"pobi", "cu"};
        RacingCars racingCars = new RacingCars(carNames);
        int tryCount = 3;
        List<RacingCars> racingGameResult = RacingGame.playRacingGame(racingCars, tryCount,new MoveRule());

        assertThat(racingGameResult.size()).isEqualTo(tryCount);
    }
}
