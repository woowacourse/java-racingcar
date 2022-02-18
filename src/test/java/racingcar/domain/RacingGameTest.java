package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    @DisplayName("챔피언이 한명인 경우 챔피언 이름 받기")
    void getChampionNamesOnlyOneChampion() {
        Cars cars = new Cars(Arrays.asList("car1", "car2", "car3"));

        cars.getCarList().get(0).move(5);
        cars.getCarList().get(1).move(1);
        cars.getCarList().get(2).move(3);

        RacingGame racingGame = new RacingGame(cars, 0);

        assertThat(racingGame.getChampionNames())
            .contains("car1")
            .doesNotContain("car2")
            .doesNotContain("car3");
    }

    @Test
    @DisplayName("챔피언이 여러명인 경우 챔피언 이름 받기")
    void getChampionNames() {
        Cars cars = new Cars(Arrays.asList("car1", "car2", "car3"));

        cars.getCarList().get(0).move(5);
        cars.getCarList().get(1).move(5);
        cars.getCarList().get(2).move(3);

        RacingGame racingGame = new RacingGame(cars, 0);

        assertThat(racingGame.getChampionNames())
            .contains("car1")
            .contains("car2")
            .doesNotContain("car3");
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