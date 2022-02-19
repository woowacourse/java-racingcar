package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    @DisplayName("챔피언이 한명인 경우 챔피언 이름 수는 하나")
    void getChampionNamesOnlyOneChampion() {
        Cars cars = new Cars(Arrays.asList("car1", "car2", "car3"));
        RacingGame racingGame = new RacingGame(cars, 1);

        cars.getCarList().get(0).move(5);
        cars.getCarList().get(0).move(5);

        while (!racingGame.isFinished()) {
            racingGame.run();
        }

        assertThat(racingGame.getChampionNames().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("챔피언이 여러명일 수 있는 경우 챔피언 이름 수 체크")
    void getChampionNames() {
        Cars cars = new Cars(Arrays.asList("car1", "car2", "car3"));
        RacingGame racingGame = new RacingGame(cars, 3);

        while (!racingGame.isFinished()) {
            racingGame.run();
        }

        assertThat(racingGame.getChampionNames().size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    @DisplayName("라운드가 끝나지 않았음을 판별")
    void reduceRoundsAndIsNotFinished() {
        Cars cars = new Cars(Arrays.asList("car1", "car2", "car3"));
        RacingGame racingGame = new RacingGame(cars, 3);

        racingGame.run();

        assertThat(racingGame.isFinished()).isEqualTo(false);
    }

    @Test
    @DisplayName("라운드가 끝났음을 판별")
    void reduceRoundsAndIsFinished() {
        Cars cars = new Cars(Arrays.asList("car1", "car2", "car3"));
        RacingGame racingGame = new RacingGame(cars, 1);

        racingGame.run();

        assertThat(racingGame.isFinished()).isEqualTo(true);
    }

    @Test
    @DisplayName("라운드수가 0이 되면 게임을 진행 시킬 수 없도록 한다")
    void runRacingGameWhenRoundsZero() {
        Cars cars = new Cars(Arrays.asList("car1", "car2", "car3"));
        RacingGame racingGame = new RacingGame(cars, 0);

        assertThatThrownBy(() -> {
            racingGame.run();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}