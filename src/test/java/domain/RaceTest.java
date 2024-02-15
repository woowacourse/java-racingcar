package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RaceTest {

    @Test
    void play() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("one"));
        cars.add(new Car("two"));
        Race race = new Race(2, cars);

        String result = race.play();

        assertThat(result).contains("one :", "two : ");
    }
}