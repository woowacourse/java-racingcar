package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingGame;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @Test
    void 시도횟수만큼_경기진행시_종료_확인() {
        Car car1 = new Car("aaa");
        Car car2 = new Car("bbb");
        List<Car> cars = Arrays.asList(car1, car2);

        RacingGame racingGame = RacingGame.createRacingGame(cars, "2");
        racingGame.race();
        racingGame.race();
        assertThat(racingGame.isEnd()).isTrue();
    }
}