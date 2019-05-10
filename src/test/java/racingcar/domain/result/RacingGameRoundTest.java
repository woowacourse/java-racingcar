package racingcar.domain.result;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameRoundTest {
    @Test
    void toString_메소드가_정상적으로_작동하는지_테스트() {
        List<Car> cars = Arrays.asList(new Car("red", 1),
                new Car("blue", 2), new Car("green", 0));
        RacingGameRound racingGameRound = new RacingGameRound(cars);

        assertEquals(racingGameRound.toString(), "red   : -\nblue  : --\ngreen : \n");
    }

    @Test
    void 우승자_리스트를_생성하는_메소드가_정상적으로_작동하는지_테스트() {
        List<Car> cars = Arrays.asList(new Car("red", 2),
                new Car("blue", 2), new Car("green", 0));
        RacingGameRound racingGameRound = new RacingGameRound(cars);
        List<Car> actual = Arrays.asList(new Car("red"), new Car("blue"));

        assertEquals(racingGameRound.getWinners(), actual);
    }
}