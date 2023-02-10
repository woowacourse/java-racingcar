package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class RefereeTest {

    private static final int FORWARD = 4;

    @Test
    void judgeWinner() {
        Referee referee = new Referee();

        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Car carC = new Car("carC");

        carB.move(FORWARD);
        carC.move(FORWARD);

        Cars cars = new Cars(List.of(carA, carB, carC));
        Cars winner = referee.judgeWinner(cars);

        assertThat(winner.getCars()).containsExactly(carB, carC);
    }
}
