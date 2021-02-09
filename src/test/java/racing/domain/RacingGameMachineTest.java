package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.number.TryCount;

import static org.assertj.core.api.Assertions.assertThatCode;

class RacingGameMachineTest {
    private static final Cars DUMMY_CARS = Cars.generate("pobi,brown");

    @DisplayName("Cars 객체와 1이상의 tryCounts를 할당받으면, 게임이 시작된다.")
    @Test
    void Machine_Cars_객체와_tryCounts를_입력받으면_게임이_시작된다() {
        TryCount tryCount = new TryCount(3);
        RacingGameMachine racingGameMachine = new RacingGameMachine(DUMMY_CARS, tryCount);
        assertThatCode(() -> racingGameMachine.play())
                .doesNotThrowAnyException();
    }
}