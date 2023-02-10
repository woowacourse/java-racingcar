package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarStatus;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private RacingGame racingGame;
    private final Cars cars = new Cars(List.of("pobi", "crong", "honux"));

    @BeforeEach
    void setup() {
        racingGame = new RacingGame(cars, 1, new TestNumberGenerator(7));
    }

    @Test
    @DisplayName("한 턴을 진행하면 자동차들은 한 칸씩 움직인다")
    void takeOneTurnTurn() {
        List<CarStatus> carStatuses = racingGame.takeOneTurn();
        carStatuses.forEach(carStatus ->
                assertThat(carStatus.getCurrentPosition())
                        .isEqualTo(1)
        );
    }

    @Nested
    @DisplayName("레이싱이 종료되었는지 확인하는 메서드가 올바르게 동작하는지 확인한다.")
    class isFinishTest {
        @Test
        @DisplayName("남은 시도 횟수가 0인 경우 true를 반환한다")
        void isFinishTrueCase() {
            racingGame.takeOneTurn();
            assertThat(racingGame.isFinish())
                    .isTrue();
        }

        @Test
        @DisplayName("남은 시도 횟수가 1인 경우 false를 반환한다")
        void isFinishFalseCase() {
            assertThat(racingGame.isFinish())
                    .isFalse();
        }
    }
}