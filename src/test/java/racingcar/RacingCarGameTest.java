package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingCarGameTest {
    private RacingCarGame racingCarGame;

    @BeforeEach
    void setUp() {
        racingCarGame = new RacingCarGame();
    }

    @ParameterizedTest
    @MethodSource("provideCars")
    @DisplayName("우승자를 정상적으로 판별하는지 확인한다.")
    void getWinners(List<Car> players, List<String> expectedWinners) {
        CarRepository.updateCars(players);
        assertThat(racingCarGame.getWinners()).isEqualTo(expectedWinners);
    }

}