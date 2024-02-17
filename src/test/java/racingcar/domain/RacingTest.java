package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingTest {

    @DisplayName("가장 멀리간 차가 우승자가 된다.")
    @Test
    void findSingleWinnerTest() {
        final MockCar carA = new MockCar(1);
        final MockCar carB = new MockCar(2);
        final List<Car> cars = List.of(carA, carB);
        final Racing racing = new Racing(cars, () -> true);

        final List<Car> winners = racing.findWinner();

        Assertions.assertThat(winners).containsExactlyInAnyOrder(carB);
    }

    @DisplayName("우승자가 여려명이 될 수 있다.")
    @Test
    void findMultipleWinnerTest() {
        final MockCar carA = new MockCar(2);
        final MockCar carB = new MockCar(2);
        final MockCar carC = new MockCar(1);
        final List<Car> cars = List.of(carA, carB, carC);
        final Racing racing = new Racing(cars, () -> true);

        final List<Car> winners = racing.findWinner();

        Assertions.assertThat(winners).containsExactlyInAnyOrder(carA, carB);
    }

    @DisplayName("전략에 따라 전진 유무가 결정된다.")
    @ParameterizedTest
    @CsvSource({"true, 1", "false, 0"})
    void moveTest(final boolean isMove, final int expectedPosition) {
        final MockCar carA = new MockCar();
        final List<Car> cars = List.of(carA);
        final Racing racing = new Racing(cars, () -> isMove);

        racing.move();

        Assertions.assertThat(carA.getPosition()).isEqualTo(expectedPosition);
    }
}
