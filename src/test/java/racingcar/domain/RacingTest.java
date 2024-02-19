package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingTest {

    private final MockCar onePositionCar = new MockCar(1);
    private final MockCar twoPositionCarA = new MockCar(2);
    private final MockCar twoPositionCarB = new MockCar(2);

    @DisplayName("가장 멀리간 차가 우승자가 된다.")
    @Test
    void findSingleWinnerTest() {
        final List<Car> cars = List.of(onePositionCar, twoPositionCarA);
        final Racing racing = new Racing(cars, () -> true);

        final List<Car> winners = racing.findWinner();

        Assertions.assertThat(winners).containsExactlyInAnyOrder(twoPositionCarA);
    }

    @DisplayName("우승자가 여려명이 될 수 있다.")
    @Test
    void findMultipleWinnerTest() {
        final List<Car> cars = List.of(onePositionCar, twoPositionCarA, twoPositionCarB);
        final Racing racing = new Racing(cars, () -> true);

        final List<Car> winners = racing.findWinner();

        Assertions.assertThat(winners).containsExactlyInAnyOrder(twoPositionCarA, twoPositionCarB);
    }

    @DisplayName("전략에 따라 전진 유무가 결정된다.")
    @ParameterizedTest
    @CsvSource({"true, 1", "false, 0"})
    void moveTest(final boolean isMove, final int expectedPosition) {
        final MockCar car = new MockCar();
        final Racing racing = new Racing(List.of(car), () -> isMove);

        racing.move();

        Assertions.assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }
}
