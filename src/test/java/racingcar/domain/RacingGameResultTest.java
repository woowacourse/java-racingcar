package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameResultTest {

    @Test
    @DisplayName("우승자 리턴 - 단일 우승자")
    public void getWinners_singleWinner() {
        Car winner = new Car(CarName.valueOf("car1"), Position.valueOf(2));
        Car loser = new Car(CarName.valueOf("car2"), Position.valueOf(1));
        RacingGameResult gameResult = new RacingGameResult(
                new Cars(Arrays.asList(winner, loser))
        );

        assertThat(gameResult.getWinners()).containsExactly(winner);
    }

    @Test
    @DisplayName("우승자 리턴 - 공동 우승자")
    public void getWinners_manyWinners() {
        RacingGameResult gameResult = new RacingGameResult(Cars.from("joy1,joy2"));

        assertThat(gameResult.getWinners())
                .containsExactly(Car.from("joy1"), Car.from("joy2"));
    }

}