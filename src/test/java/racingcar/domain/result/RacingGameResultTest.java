package racingcar.domain.result;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.utils.CloneUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameResultTest {
    @Test
    void DB에서_winners_리스트를_올바르게_추출해_오는지_테스트() {
        List<Car> cars = Arrays.asList(new Car("red"), new Car("blue"), new Car("green"));
        List<RacingGameRound> gameResultHistory = new ArrayList<>();

        cars.get(0).accelerate(7);
        cars.get(1).accelerate(7);
        cars.get(2).accelerate(7);
        gameResultHistory.add(new RacingGameRound(CloneUtils.copyAllCars(cars)));

        cars.get(0).accelerate(1);
        cars.get(1).accelerate(7);
        cars.get(2).accelerate(7);
        gameResultHistory.add(new RacingGameRound(CloneUtils.copyAllCars(cars)));

        List<Car> actual = Arrays.asList(new Car("blue"), new Car("green"));

        assertEquals(new RacingGameResult(gameResultHistory).getWinners(), actual);
    }
}