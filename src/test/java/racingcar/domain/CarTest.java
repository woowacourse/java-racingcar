package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("car move 테스트 (랜덤 숫자가 4이상일 경우에만 전진)")
    public void check_car_move_by_random_number() {
        Name name = new Name("test");
        Car car = new Car(name);

        car.move(4);
        assertThat(car.getDistance()).isEqualTo(1);
        car.move(0);
        assertThat(car.getDistance()).isEqualTo(1);
    }

}