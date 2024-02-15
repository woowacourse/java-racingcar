package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgeTest {

    private final Judge judge = new Judge();

    @Test
    void getWinners() {
        Car one = new Car("one");
        Car two = new Car("two");
        Car three = new Car("three");

        List<Car> cars = new ArrayList<>();
        cars.add(one);
        cars.add(two);
        cars.add(three);

        one.move(4);
        two.move(0);
        three.move(8);

        String winners = judge.getWinners(cars);

        assertThat(winners).isEqualTo("one, three가 최종 우승했습니다.");
    }
}