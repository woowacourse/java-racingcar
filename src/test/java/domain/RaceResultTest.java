package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceResultTest {

    @Test
    @DisplayName("모든 자동차가 같은 거리를 움직였을 때 우승자를 잘 반환하는지 확인한다.")
    void getWinners() {
        // given
        // when
        RaceResult raceResult = RacingGame.of(new Count(1), Cars.from(List.of("a", "b", "c")),
                new RandomMovementGenerator(((minNumber, maxNumber) -> 5))).race();
        // then
        assertAll(
                () -> assertThat(raceResult.getWinners()).contains("a"),
                () -> assertThat(raceResult.getWinners()).contains("b"),
                () -> assertThat(raceResult.getWinners()).contains("c")
                );

    }

    @Test
    @DisplayName("정확한 개수의 턴을 반환하는지 확인한다")
    void getResult() {
        // given
        // when
        RaceResult raceResult = RacingGame.of(new Count(1), Cars.from(List.of("a", "b", "c")),
                new RandomMovementGenerator(((minNumber, maxNumber) -> 5))).race();
        // then
        assertThat(raceResult.getResult()).size().isEqualTo(1);
    }
}
