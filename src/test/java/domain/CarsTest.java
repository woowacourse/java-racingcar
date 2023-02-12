package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class CarsTest {

    private static final int FORWARD = 4;

    @Test
    void judgeWinner() {
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Car carC = new Car("carC");

        carB.move(FORWARD);
        carC.move(FORWARD);

        Cars cars = new Cars(List.of(carA, carB, carC));
        Cars winner = cars.judgeWinners();

        assertThat(winner.getStream()
                .collect(Collectors.toList()))
                .containsExactly(carB, carC);
    }
}
