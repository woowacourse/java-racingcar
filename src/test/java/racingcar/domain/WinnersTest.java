package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {

    @DisplayName("우승자 1명")
    @Test
    void createWinner1() {
        Cars cars = Cars.fromCars(Arrays.asList(
                new Car("rick", 3), new Car("huni", 0)));

        Winners winners = new Winners(cars);

        assertThat(winners.getWinners())
                .containsExactly("rick");
    }

    @DisplayName("공동 우승자 2명")
    @Test
    void createWinner2() {
        Cars cars = Cars.fromCars(Arrays.asList(
                new Car("rick", 4), new Car("huni", 4)));

        Winners winners = new Winners(cars);

        assertThat(winners.getWinners())
                .containsExactly("rick", "huni");
    }

}