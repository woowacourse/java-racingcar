package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Name;
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
        cars.replaceAll((car) -> new Car(car.getName().getValue(), new FixedEngine(5)));
        cars.add(new Car("loser", new FixedEngine(0)));
        while (racingGame.isContinue()) {
            racingGame.race();
        }

        // then
        List<Name> winnerNames = racingGame.findWinners()
            .stream()
            .map(car -> car.getName())
            .collect(Collectors.toList());
        assertThat(winnerNames).isEqualTo(Arrays.asList(Name.of("pobi"), Name.of("jason")));
    }

}