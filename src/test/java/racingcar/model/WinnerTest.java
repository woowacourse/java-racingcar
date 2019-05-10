package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {
    @Test
    void 우승자_전부인_경우() {
        List<Car> cars = Arrays.asList(new Car("car1", 0),
                new Car("car2", 0), new Car("car3", 0));
        Winner winner = new Winner(cars);
        assertThat(winner.getWinnerCarNames()).isEqualTo(Arrays.asList("car1", "car2", "car3"));
    }

    @Test
    void 우승자_한명인_경우() {
        List<Car> cars = Arrays.asList(new Car("car1", 1),
                new Car("car2", 0), new Car("car3", 0));
        Winner winner = new Winner(cars);
        assertThat(winner.getWinnerCarNames()).isEqualTo(Arrays.asList("car1"));
    }

}