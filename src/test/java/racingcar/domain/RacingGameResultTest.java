package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameResultTest {

    @Test
    @DisplayName("")
    public void getWinners_singleWinner() {
        Car winner = new Car("winner", 2);
        Car loser = new Car("loser", 1);
        RacingGameResult gameResult = new RacingGameResult(
                new Cars(Arrays.asList(winner, loser))
    );

        assertThat(gameResult.getWinners()).containsExactly(winner);
    }

    @Test
    @DisplayName("getWinners")
    public void getWinners_manyWinners() {
        RacingGameResult gameResult = new RacingGameResult(Cars.from("joy1,joy2"));

        assertThat(gameResult.getWinners())
                .isEqualTo(Arrays.asList(Car.from("joy1"), Car.from("joy2")));
    }

}