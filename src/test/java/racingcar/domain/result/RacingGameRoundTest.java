package racingcar.domain.result;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingGameRoundTest {
    List<Car> cars;

    @BeforeEach
    public void setUp() {
        cars = Arrays.asList(new Car("red", 2), new Car("blue", 2)
                , new Car("green", 1));
    }

    @Test
    public void RacingGameRound클래스의_toString메소드가_정상작동되는지_검사() {
        RacingGameRound racingGameRound = new RacingGameRound(cars);
        assertEquals("red   : --\nblue  : --\ngreen : -\n", racingGameRound.toString());
    }

    @Test
    public void 우승자_리스트를_생성하는_메소드_정상작동하는지_확인() {
        RacingGameRound racingGameRound = new RacingGameRound(cars);
        List<Car> expected = Arrays.asList(new Car("red", 2), new Car("blue", 2));

        assertEquals(expected, racingGameRound.getWinners());
    }

    @AfterEach
    public void tearDown() {
        cars = null;
    }
}