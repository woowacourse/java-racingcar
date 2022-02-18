package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("만약 매개변수로 true가 들어오면 한 칸 이동한다.")
    @Test
    public void move() {
        Car car = new Car("Thor");
        car.move(true);
        assertThat(car.getPosition()).isNotEqualTo(Position.createStartPosition());
    }

    @DisplayName("같은 위치인지 차량끼리 비교하여 결과를 반환한다.")
    @Test
    public void isSamePosition() {
        Car car1 = new Car("Thor");
        Car car2 = new Car("Eden");
        car1.move(true);
        assertThat(car1.isSamePosition(car2)).isNotEqualTo(true);
    }
}
