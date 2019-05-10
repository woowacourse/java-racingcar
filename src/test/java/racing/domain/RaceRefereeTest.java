package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceRefereeTest {
    @Test
    void 우승자찾기테스트() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 5));
        cars.add(new Car("crong", 2));
        cars.add(new Car("honux", 5));

        RaceReferee result = new RaceReferee(cars);
        List<Car> winners = result.judgeWinners();

        assertThat(winners).contains(new Car[]{new Car("pobi", 5), new Car("honux", 5)});
    }

}
