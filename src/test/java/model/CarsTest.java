package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {
    private static final int MOVE = 6;
    private static final int STOP = 1;

    @DisplayName("자동차 이름이 중복되면 에러가 발생한다.")
    @Test
    void nameDuplicatedTest() {
        final List<Car> carNames = List.of(Car.from("lemon"), Car.from("lemon"));
        assertThatThrownBy(() -> Cars.from(carNames)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름 개수가 2개 미만이면 에러가 발생한다.")
    @Test
    void carNameCountTest() {
        final List<Car> carNames = List.of(Car.from("lemon"));
        assertThatThrownBy(() -> Cars.from(carNames)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("가장 멀리 이동한 자동차가 두대일 경우 이름 두개를 반환하는지 테스트")
    @Test
    void findMaxPositionCarNameTest() {
        final String winner = "car1";
        final String notWinner = "car2";
        final String winner2 = "car3";

        final Car car1 = Car.from(winner);
        final Car car2 = Car.from(notWinner);
        final Car car3 = Car.from(winner2);

        car1.moveForward(MOVE);
        car1.moveForward(MOVE);

        car2.moveForward(MOVE);
        car2.moveForward(STOP);

        car3.moveForward(MOVE);
        car3.moveForward(MOVE);

        final Cars cars = Cars.from(List.of(car1, car2, car3));
        assertEquals(cars.findMaxPositionCarName(), List.of(winner, winner2));
    }
}
