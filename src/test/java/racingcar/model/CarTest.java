package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.CarsTest.AlwaysMoveNumberGenerator;
import racingcar.model.CarsTest.NoMoveNumberGenerator;

class CarTest {

    @DisplayName("전진하는 경우")
    @Test
    void goPassable() {
        Car a = Car.from("a");

        a.go(new AlwaysMoveNumberGenerator());

        assertThat(a.getPosition()).isEqualTo(1);
    }

    @DisplayName("전진하지 않는 경우")
    @Test
    void cantGo() {
        Car car = Car.from("a");

        car.go(new NoMoveNumberGenerator());

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("시작은 서로 같은 위치에서 시작")
    void isSamePosition() {
        Car a = Car.from("a");
        Car b = Car.from("b");

        assertThat(a.isSamePosition(b)).isTrue();
    }

    @Test
    @DisplayName("서로 다른 위치인 경우")
    void isNotSamePosition() {
        Car a = Car.from("a");
        Car b = Car.from("b");

        b.go(new AlwaysMoveNumberGenerator());

        assertThat(a.isSamePosition(b)).isFalse();
    }
}
