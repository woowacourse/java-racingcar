package racing.domain;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RacingTest {
    static Stream<Arguments> getMultipleWinnersParameters() {
        return Stream.of(
                Arguments.of(List.of(new Car(0, "test1"), new Car(1, "test2")),
                        List.of(new Car(1, "test2"))),
                Arguments.of(List.of(new Car(1, "test1"), new Car(1, "test2")),
                        List.of(new Car(1, "test1"), new Car(1, "test2")))
        );
    }

    @Test
    @DisplayName("레이스 테스트")
    void doRace() {
        List<Integer> racingCondition = List.of(3, 4);
        List<Car> expectedCars = List.of(new Car(0, "test"), new Car(1, "test2"));
        List<Car> testCars = List.of(new Car(0, "test"), new Car(0, "test2"));
        Racing testRacing = new Racing(testCars, 1);
        Racing expectedRacing = new Racing(expectedCars, 1);
        testRacing.doRace(racingCondition);
        Assertions.assertThat(testRacing)
                .isEqualTo(expectedRacing);
    }

    @ParameterizedTest
    @MethodSource("getMultipleWinnersParameters")
    void getMultipleWinners(List<Car> testCars, List<Car> expectedCars) {
        Racing racing = new Racing(testCars, 1);
        racing.doRace(List.of(1, 1));
        List<Car> result = racing.getWinners();
        Assertions.assertThat(result)
                .containsExactlyElementsOf(expectedCars);
    }
}