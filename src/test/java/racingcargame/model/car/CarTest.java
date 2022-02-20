package racingcargame.model.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcargame.dto.CarDto;

class CarTest {

    @DisplayName("자동차를 원하는 만큼 이동시킨다.")
    @Test
    void moveCar() {
        final Car car = new Car("마크");
        car.moveCar(2);
        final CarDto actual = car.changeToDto();
        final CarDto expected = new CarDto("마크", 2);

        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getPosition()).isEqualTo(expected.getPosition());
    }

    @DisplayName("자동차 위치 값이 같은지 학인한다.")
    @Test
    void hasSamePosition() {
        final Car car = new Car("마크");
        final Car actual = new Car("위챠");
        car.moveCar(2);
        actual.moveCar(2);

        assertThat(car.hasSamePosition(actual)).isEqualTo(true);
    }

    @DisplayName("자동차 위치 값이 다른지 확인한다.")
    @Test
    void compareTo() {
        final Car car = new Car("마크");
        final Car actual = new Car("위챠");
        car.moveCar(4);
        actual.moveCar(2);

        assertThat(car.compareTo(actual)).isEqualTo(false);
    }
}