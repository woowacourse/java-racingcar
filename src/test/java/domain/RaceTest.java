package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RaceTest {

    @Test
    void play() {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("one"));
        cars.add(new Car("two"));
        Race race = new Race(2, cars);

        //when
        String result = race.play();

        //then
        assertThat(result).contains("one :", "two : ");
    }
}