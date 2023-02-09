package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class RacingCarGameTest {
    private RacingCarGame racingCarGame;

    @BeforeEach
    void setUp() {
        racingCarGame = new RacingCarGame();
    }

    @ParameterizedTest
    @MethodSource("provideCars")
    @DisplayName("메서드를 인수로 전달")
    void getWinners(List<Car> players, List<String> expectedWinners) {
        CarRepository.updateCars(players);
        assertThat(racingCarGame.getWinners()).isEqualTo(expectedWinners);
    }

    private static Stream<Arguments> provideCars() {

        return Stream.of(
                Arguments.of(List.of(new Car("pobi", 0), new Car("mery", 0), new Car("abel", 0)), List.of("pobi", "mery", "abel")),
                Arguments.of(List.of(new Car("pobi", 3), new Car("mery", 1), new Car("abel", 1)), List.of("pobi")),
                Arguments.of(List.of(new Car("pobi", 3), new Car("mery", 3), new Car("abel", 1)), List.of("pobi", "mery")),
                Arguments.of(List.of(new Car("pobi", 3), new Car("mery", 3), new Car("abel", 3)), List.of("pobi", "mery", "abel"))
        );
    }

    @AfterEach
    void clear() {
        CarRepository.clear();
    }
}