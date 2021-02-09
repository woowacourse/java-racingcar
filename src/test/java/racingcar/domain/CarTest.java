package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("자동차 이름이 5자보다 길경우 예외가 발생하는지 테스")
    public void check_car_name_exception() {
        String carName = "testException";
        assertThatThrownBy(() -> new Car(carName))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("[Error] 자동차 이름은 5자이하여야 합니다.");
    }

    @Test
    @DisplayName("car move 테스트 (랜덤 숫자가 4이상일 경우에만 전진)")
    public void check_car_move_by_random_number() {
        Car car = new Car("test");

        car.move(4);
        assertThat(car.getCarName()).isEqualTo("test");
        car.move(1);
        assertThat(car.getCarName()).isEqualTo("test");
    }

}