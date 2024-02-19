package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingGameTest {
    private CarRacingGame carRacingGame;

    @BeforeEach
    void setUp() {
        Cars cars = new Cars(
                Arrays.asList(
                        new Car("pobi", 3),
                        new Car("crong", 1),
                        new Car("honux", 3)
                )
        );
        carRacingGame = new CarRacingGame(cars, new Round(1));
    }

    @Test
    @DisplayName("자동차 경주를 진행할 수 있다.")
    void race() {
        List<RoundResult> raceResult = carRacingGame.race(new RandomNumberGenerator());
        assertThat(raceResult).hasSize(1);
    }

    @Test
    @DisplayName("자동차 경주의 우승자를 구할 수 있다.")
    void findWinners() {
        List<String> winners = carRacingGame.findWinners();
        assertThat(winners).containsExactly("pobi", "honux");
    }
}
