package racingcargame.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    Winner winner;

    @BeforeEach
    void setup() {
        winner = new Winner();
    }

    @Test
    void 최종_우승자_1명_판단() {
        List<Car> cars = Arrays.asList(new Car("pobi", 2),
                new Car("crong", 3),
                new Car("honux", 1));

        //assertThat(winner.makeWinner(cars).size()).isEqualTo(1);
        assertThat(winner.makeWinner(cars).contains("crong")).isTrue();
    }

    @Test
    void 최종_우승자_여러명_판단() {
        List<Car> cars = Arrays.asList(new Car("pobi", 2),
                new Car("crong", 3),
                new Car("honux", 3),
                new Car("jason", 1));

        //assertThat(winner.makeWinner(cars).size()).isEqualTo(2);
        assertThat(winner.makeWinner(cars)).isEqualTo(Arrays.asList("crong", "honux"));
    }

    @AfterEach
    void tearDown() {
        winner = null;
    }
}
