package racingcargame.model.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcargame.dto.CarDto;

class CarTest {

    private final Car car = new Car("마크");

    @DisplayName("자동차 이동이 정상적으로 이루어지는지 테스트")
    @Test
    void moveCar() {
        car.moveCar(2);
        CarDto actual = car.changeToDto();
        CarDto expected = new CarDto("마크", 2);

        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getPosition()).isEqualTo(expected.getPosition());
    }

    @DisplayName("자동차 position이 같은 경우가 정상적으로 이루어지는지 테스트")
    @Test
    void hasSamePosition() {
        Car actual = new Car("위챠");
        car.moveCar(2);
        actual.moveCar(2);

        assertThat(car.hasSamePosition(actual)).isEqualTo(true);
    }

    @DisplayName("자동차 position 비교가 정상적으로 이루어지는지 테스트")
    @Test
    void compareTo() {
        Car actual = new Car("위챠");
        car.moveCar(4);
        actual.moveCar(2);

        assertThat(car.compareTo(actual)).isEqualTo(-1);
    }
}