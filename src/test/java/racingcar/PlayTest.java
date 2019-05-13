package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayTest {
    @Test
    void carStateTest() {
        ArrayList<Car> cars = new ArrayList<>();
        List<String> states = Arrays.asList("a : -", "b : --");

        cars.add(new Car("a", 1));
        cars.add(new Car("b", 2));
        assertThat(Play.getCarStates(new Cars(cars))).isEqualTo(states);
    }
}