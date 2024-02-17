package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarNames;
import racingcar.domain.result.CarResult;
import racingcar.domain.result.RoundResult;

class RacingGameTest {

    @DisplayName("Play시 라운드만큼 게임이 진행된다.")
    @Test
    void play() {
        // given
        final RacingGame racingGame = RacingGame.of(CarNames.from("a,b,c"), Round.from("3"));

        // when
        final List<RoundResult> roundResults = racingGame.play(() -> 5);

        // then
        assertThat(roundResults)
                .hasSize(3)
                .extracting("carResults")
                .containsAll(
                        List.of(
                                List.of(
                                        new CarResult("a", 1),
                                        new CarResult("b", 1),
                                        new CarResult("c", 1)
                                ), List.of(
                                        new CarResult("a", 2),
                                        new CarResult("b", 2),
                                        new CarResult("c", 2)
                                ), List.of(
                                        new CarResult("a", 3),
                                        new CarResult("b", 3),
                                        new CarResult("c", 3)
                                )
                        )
                );
    }
}
