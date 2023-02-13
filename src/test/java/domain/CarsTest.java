package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void judgeWinnersTest() {
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Car carC = new Car("carC");

        carB.move();
        carC.move();

        Cars cars = new Cars(List.of(carA, carB, carC));
        Winners winners = cars.judgeWinners();

        assertThat(winners.getWinners())
                .containsExactly("carB", "carC");
    }
}
