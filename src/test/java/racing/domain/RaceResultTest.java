package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceResultTest {
    @Test
    void 공동우승() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 5));
        cars.add(new Car("crong", 2));
        cars.add(new Car("honux", 5));

        RaceResult result = new RaceResult(cars);
        List<Car> winners = result.judgeWinners();

        assertThat(winners).contains(new Car[]{new Car("pobi", 5), new Car("honux", 5)});
    }

    @Test
    void 단독우승() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 5));
        cars.add(new Car("crong", 2));
        cars.add(new Car("honux", 3));

        RaceResult result = new RaceResult(cars);
        List<Car> winners = result.judgeWinners();

        assertThat(winners).contains(new Car[]{new Car("pobi", 5)});
    }
}
