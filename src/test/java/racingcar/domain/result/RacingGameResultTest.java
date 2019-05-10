package racingcar.domain.result;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.util.CloneUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameResultTest {

    @Test
    void DB에서_winners_리스트를_잘_가지고오는지_검사() {
        List<Car> carList = Arrays.asList(new Car("red"), new Car("blue"), new Car("green"));
        List<RacingGameRound> gameResultDB = new ArrayList<>();

        carList.get(0).accelerate(4);
        carList.get(1).accelerate(4);
        carList.get(2).accelerate(4);
        gameResultDB.add(new RacingGameRound(CloneUtil.cloneCarList(carList)));

        carList.get(0).accelerate(3);
        carList.get(1).accelerate(4);
        carList.get(2).accelerate(4);
        gameResultDB.add(new RacingGameRound(CloneUtil.cloneCarList(carList)));

        List<Car> actual = Arrays.asList(new Car("blue", 2), new Car("green", 2));

        assertThat(actual).isEqualTo(new RacingGameResult(gameResultDB).getWinners());
    }
}