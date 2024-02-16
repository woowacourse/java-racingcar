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
        // given
        Car kaki = Car.createOnStart("kaki");
        Car nak = Car.createOnStart("nak");

        // when
        kaki.move(1);

        // then
        RandomMovingCars randomMovingCars = new RandomMovingCars(List.of(
                new RandomMovingCar(kaki, () -> 0),
                new RandomMovingCar(nak, () -> 0)
        ));

        Winners winners = Winners.from(randomMovingCars);
        assertThat(winners.getWinners())
                .containsExactly("kaki");
    }
}
