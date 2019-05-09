package racingcar.domain.result;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.util.CloneUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameResultTest {

    @Test
    void DB에서_winners_리스트를_잘_가지고오는지_검사() {
        List<Car> carList = Arrays.asList(new Car("red"), new Car("blue"), new Car("green"));
        List<RacingGameRound> gameResultDB = new ArrayList<>();

        carList.get(0).accelerate(7);
        carList.get(1).accelerate(7);
        carList.get(2).accelerate(7);
        gameResultDB.add(new RacingGameRound(CloneUtil.cloneCarList(carList)));

        carList.get(0).accelerate(1);
        carList.get(1).accelerate(7);
        carList.get(2).accelerate(7);
        gameResultDB.add(new RacingGameRound(CloneUtil.cloneCarList(carList)));

        List<Car> actual = Arrays.asList(new Car("blue"), new Car("green"));

        assertEquals(actual, new RacingGameResult(gameResultDB).getWinners());
    }
}