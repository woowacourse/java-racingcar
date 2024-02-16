package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgeTest {

    private final Judge judge = new Judge();

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 우승한다")
    void getWinners() {
        //given
        Car one = new Car("one");
        Car two = new Car("two");
        Car three = new Car("three");
        List<Car> cars = new ArrayList<>(List.of(one, two, three));
        RaceCars raceCars = new RaceCars(cars);

        one.move(4);
        two.move(0);
        three.move(8);

        //when
        List<Car> winners = judge.getWinners(raceCars);

        //then
        assertThat(winners).contains(one, three);
    }
}