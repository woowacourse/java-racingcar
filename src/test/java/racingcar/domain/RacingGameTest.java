package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.result.RacingGameResult;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @Test
    void 경기진행결과DB가_정상적으로_만들어졌는지_검사() {
        List<Car> cars = Arrays.asList(new Car("red"), new Car("blue"), new Car("green"));
        GameCount gameCount = new GameCount(6);
        RacingGameResult racingGameResult = new RacingGame(cars, gameCount).start();

        assertEquals(gameCount.getGameCount(), racingGameResult.getGameResultDB().size());
    }

}