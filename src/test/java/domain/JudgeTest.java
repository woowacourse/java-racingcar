package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgeTest {

    private final Judge judge = new Judge();

    @Test
    void getWinners() {
        //given
        Car one = new Car("one");
        Car two = new Car("two");
        Car three = new Car("three");

        List<Car> cars = new ArrayList<>(List.of(one, two, three));

        one.move(4);
        two.move(0);
        three.move(8);

        //when
        List<Car> winners = judge.getWinners(cars);

        //then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo("one");
        assertThat(winners.get(1).getName()).isEqualTo("three");
    }
}