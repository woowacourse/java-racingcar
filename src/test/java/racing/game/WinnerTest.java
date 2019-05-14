package racing.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinnerTest {
    @Test
    void 챔피언이_하나일때_챔피언계산() {
        List<Car> cars;
        try {
            cars = Arrays.asList(new Car[]{new Car("pobi", 2), new Car("jihoo"), new Car("jinwo")});
            Winner winner = new Winner();
            winner.calculateChampions(cars);
            assertThat(winner.getWinners()).isEqualTo(Arrays.asList(new Car("pobi", 2)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void 챔피언이_여러명일때_챔피언계산() {
        List<Car> cars;
        try {
            cars = Arrays.asList(new Car[]{new Car("pobi", 2), new Car("jihoo", 2), new Car("jinwo")});
            Winner winner = new Winner();
            winner.calculateChampions(cars);
            assertThat(new HashSet<>(winner.getWinners())).isEqualTo(
                    new HashSet<>(Arrays.asList(new Car("pobi", 2), new Car("jihoo", 2))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
