package racingcar.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;
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
    @DisplayName("우승자를 정상적으로 판별하는지 확인한다.")
    void getWinners(List<Car> players, List<Integer> moveCounts , List<String> expectedWinners) {
        // given
        Car pobi = new Car("pobi");
        Car mery = new Car("mery");
        Car abel = new Car("abel");
    
        moveByCount(pobi, moveCounts.get(0));
        moveByCount(mery, moveCounts.get(1));
        moveByCount(abel, moveCounts.get(2));
        List<Car> cars = List.of(pobi, mery, abel);
        CarRepository.updateCars(cars);
        
        // when
        List<String> winners = racingCarGame.getWinners();
    
        // then
        assertThat(winners).isEqualTo(expectedWinners);
    }

    private static Stream<Arguments> provideCars() {
    
        List<Car> cars = List.of(CarTest.POBI, CarTest.MERY, CarTest.ABEL);
        return Stream.of(
                Arguments.of(cars, List.of(0, 0, 0), List.of("pobi", "mery", "abel")),
                Arguments.of(cars, List.of(3, 1, 1), List.of("pobi")),
                Arguments.of(cars, List.of(3, 3, 1), List.of("pobi", "mery")),
                Arguments.of(cars, List.of(3, 3, 3), List.of("pobi", "mery", "abel"))
        );
    }
    
    private void moveByCount(Car car, int moveOfTry) {
        IntStream.range(0, moveOfTry)
                .forEach(count -> car.move(() -> true));
    }

    @AfterEach
    void clear() {
        CarRepository.clear();
    }
}