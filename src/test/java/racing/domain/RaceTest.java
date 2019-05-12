package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    Race race;

    @BeforeEach
    void setUp() {
        race = new Race();
    }

    @Test
    void 우승자찾기테스트() {
        /*
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 5));
        cars.add(new Car("crong", 2));
        cars.add(new Car("honux", 5));

        Race result = new Race(cars);
        List<Car> winners = result.judgeWinners();

        assertThat(winners).contains(new Car[]{new Car("pobi", 5), new Car("honux", 5)});
        */
    }
}
