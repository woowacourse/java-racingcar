package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import domain.car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {

    @DisplayName("가장 많이 움직인 자동차가 최종 우승자가 된다.")
    @Test
    void winnerTest() {
        Car kaki = Car.createOnStart("kaki", () -> 1);
        Car nak = Car.createOnStart("nak", () -> 0);
        kaki.move();

        Winners winners = Winners.from(Cars.from(List.of(kaki, nak)));
        assertThat(winners.getWinners())
                .containsExactly("kaki");
    }
}
