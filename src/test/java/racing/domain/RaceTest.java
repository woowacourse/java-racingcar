package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @Test
    void judgeWinnersTest() {
        List<Car> cars = new ArrayList<>(Arrays.asList(new Car[]
                {new Car("pobi", 5), new Car("crong", 3), new Car("honux", 5)}));

        List<Car> winners = Race.judgeWinners(cars);

        assertThat(winners).contains(new Car[]{new Car("pobi", 5), new Car("honux", 5)});
    }
}
