package racingcar.domain.result;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameRoundTest {

    @Test
    void RacingGameRound클래스의_toString메소드가_정상작동되는지_검사() {
        List<Car> carList = Arrays.asList(new Car("red"), new Car("blue"), new Car("green"));
        carList.get(0).accelerate(7);
        carList.get(0).accelerate(1);
        carList.get(1).accelerate(7);
        carList.get(1).accelerate(7);
        carList.get(2).accelerate(1);
        carList.get(2).accelerate(1);

        RacingGameRound racingGameRound = new RacingGameRound(carList);
        assertEquals(racingGameRound.toString(), "red   : -\nblue  : --\ngreen : \n");
    }

    @Test
    void 우승자_리스트를_생성하는_메소드_정상작동하는지_확인() {
        List<Car> carList = Arrays.asList(new Car("red"), new Car("blue"), new Car("green"));
        carList.get(0).accelerate(7);
        carList.get(0).accelerate(7);
        carList.get(1).accelerate(7);
        carList.get(1).accelerate(7);
        carList.get(2).accelerate(1);
        carList.get(2).accelerate(1);

        RacingGameRound racingGameRound = new RacingGameRound(carList);

        List<Car> actual = Arrays.asList(new Car("red"), new Car("blue"));

        assertEquals(actual, racingGameRound.getWinners());
    }
}