package domain;

import static org.assertj.core.api.Assertions.*;

import domain.Car;
import domain.Cars;
import domain.Count;
import domain.GameResult;
import domain.Movement;
import domain.MovementGenerator;
import domain.RacingGame;
import domain.RandomMovementGenerator;
import domain.RandomNumberGenerator;
import dto.TurnResult;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    @Test
    @DisplayName("전진 경우의 게임 실행 결과를 구한다.")
    void getGameResultMove() {
        // given
        MovementGenerator movementGenerator = () -> Movement.MOVE;
        RacingGame racingGame = RacingGame.of(
                Count.from(2),
                Cars.from(List.of(Car.of("pobi", 2), Car.of("kirby", 3))),
                movementGenerator);

        // when
        GameResult gameResult = racingGame.getGameResult();

        // then
        assertThat(gameResult.getGameResult()).contains(
                        TurnResult.from(Cars.from(List.of(Car.of("pobi", 3), Car.of("kirby", 4)))),
                        TurnResult.from(Cars.from(List.of(Car.of("pobi", 4), Car.of("kirby", 5)))));
    }

    @Test
    @DisplayName("전진하지 않는 경우의 게임 실행 결과를 구한다.")
    void getGameResultStay() {
        // given
        MovementGenerator movementGenerator = () -> Movement.STAY;
        RacingGame racingGame = RacingGame.of(
                Count.from(2),
                Cars.from(List.of(Car.of("pobi", 2), Car.of("kirby", 3))),
                movementGenerator);

        // when
        GameResult gameResult = racingGame.getGameResult();

        // then
        assertThat(gameResult.getGameResult()).contains(
                        TurnResult.from(Cars.from(List.of(Car.of("pobi", 2), Car.of("kirby", 3)))),
                        TurnResult.from(Cars.from(List.of(Car.of("pobi", 2), Car.of("kirby", 3)))));
    }
}