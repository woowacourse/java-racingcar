package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceResultTest {
    @Test
    void 우승자찾기테스트() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 5));
        cars.add(new Car("crong", 2));
        cars.add(new Car("honux", 5));

        RaceResult result = new RaceResult(cars);
        Car winner = result.findWinner();

        assertThat(winner.isSameRank(cars.get(0))).isEqualTo(true);
        assertThat(winner.isSameRank(cars.get(1))).isEqualTo(false);
        assertThat(winner.isSameRank(cars.get(2))).isEqualTo(true);
    }
}
