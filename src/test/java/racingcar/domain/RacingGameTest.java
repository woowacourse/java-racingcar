package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.engine.FixedEngine;

class RacingGameTest {

    @Test
    public void 우승자_판별_테스트() {
        // given
        String[] carsName = "pobi,jason".split(",");
        int numOfMove = 5;
        RacingGame racingGame = new RacingGame(carsName, numOfMove);
        List<Car> cars = racingGame.getCars();

        // when
        cars.replaceAll((car) -> new Car(car.getName(), new FixedEngine(5)));
        cars.add(new Car("loser", new FixedEngine(0)));
        while (!racingGame.isEnd()) {
            racingGame.race();
        }

        // then
        assertThat(racingGame.getWinners()).isEqualTo("pobi,jason");
    }

}