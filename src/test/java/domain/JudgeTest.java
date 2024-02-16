package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class JudgeTest {

    private final Judge judge = new Judge();

    @Test
    void getWinners() {
        //given
        Car one = new Car("one");
        Car two = new Car("two");
        Car three = new Car("three");
        Cars cars = new Cars(Arrays.asList(one, two, three));

        //when
        one.move(4);
        one.move(4);
        one.move(4);
        three.move(4);
        three.move(4);
        three.move(4);

        //then
        Assertions.assertThat(judge.getWinners(cars)).contains(one, three);
    }
}
