package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차는 ")
class CarTest {

    @Test
    @DisplayName("4 이상의 숫자가 나오면 전진한다.")
    void moveSuccessTest() {
        Car car = new Car("name");
        Integer nowDistance = car.getDistance();

        car.move(new MovementManager(), 4);

        Assertions.assertThat(car.getDistance()).isEqualTo(nowDistance + 1);
    }

    @Test
    @DisplayName("3 이하의 숫자가 나오면 정지한다.")
    void moveFailTest() {
        Car car = new Car("name");
        Integer nowDistance = car.getDistance();

        car.move(new MovementManager(), 3);

        Assertions.assertThat(car.getDistance()).isEqualTo(nowDistance);
    }

}