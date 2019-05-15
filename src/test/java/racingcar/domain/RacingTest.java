package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingTest {

    @Test
    void 랜덤숫자가_4이상일때만_움직인다() {
        Car car = new Car("Test");
        int beforePosition = car.getPosition();

        car.moveOrNot(3);
        assertTrue(beforePosition == car.getPosition());

        car.moveOrNot(4);
        assertTrue((beforePosition + 1) == car.getPosition());
    }

    @Test
    void 최종_우승자가_한_명인_경우() {
        List<Car> cars = Arrays.asList(new Car("test1", 3), new Car("test2", 4), new Car("test3", 1));
        Winner winner = new Winner(cars, 4);
        assertThat(winner.getWinnerNames().size()).isEqualTo(1);
    }

    @Test
    void 최종_우승자가_여러_명인_경우() {
        List<Car> cars = Arrays.asList(new Car("test1", 2), new Car("test2", 4), new Car("test3", 4));
        Winner winner = new Winner(cars, 4);
        assertThat(winner.getWinnerNames().size()).isEqualTo(2);
    }
}