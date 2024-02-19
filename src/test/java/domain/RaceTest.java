package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {

    @DisplayName("가장 멀리간 차가 우승자가 된다.")
    @Test
    void findSingleWinnerTest() {
        // given
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        List<Car> carList = List.of(carA, carB);
        Race race = new Race(carList, new CarMoveStrategy(new RandomDigitSupplier()));

        // when
        carB.move(true);
        List<Car> winners = race.findWinner();

        // then
        Assertions.assertThat(winners).containsExactlyInAnyOrder(carB);
    }

    @DisplayName("우승자가 여려명이 될 수 있다.")
    @Test
    void findMultipleWinnerTest() {
        // given
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Car carC = new Car("carC");
        List<Car> carList = List.of(carA, carB, carC);
        Race race = new Race(carList, new CarMoveStrategy(new RandomDigitSupplier()));

        // when
        carA.move(true);
        carB.move(true);
        List<Car> winners = race.findWinner();

        // then
        Assertions.assertThat(winners).containsExactlyInAnyOrder(carA, carB);
    }
}
