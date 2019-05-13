package racing.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    @Test
    void 우승자가_여러명인_경우() {

        List<Car> cars = Arrays.asList(new Car("pobi", 3),
                new Car("sean", 2), new Car("denis", 3), new Car("ms", 1));
        Winner winner = new Winner(cars);
        assertThat(winner.getWinners()).containsExactly("pobi","denis");
    }

    @Test
    void 우승자가_한명인_경우() {
        List<Car> cars = Arrays.asList(new Car("pobi", 3),
                new Car("sean", 2), new Car("denis", 1));
        Winner winner = new Winner(cars);
        assertThat(winner.getWinners()).containsExactly("pobi");
    }
}
