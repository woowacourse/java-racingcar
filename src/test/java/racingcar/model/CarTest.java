package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.utils.MovableNumberGenerator;
import racingcar.model.utils.NonMovableGenerator;

class CarTest {

    private final MovableNumberGenerator movableNumberGenerator = new MovableNumberGenerator();
    private final NonMovableGenerator nonMovableGenerator = new NonMovableGenerator();

    @DisplayName("만약 이동 가능하면 한 칸 이동한다.")
    @Test
    public void move_true() {
        Car car = new Car("Thor");
        car.move(movableNumberGenerator);
        assertThat(car.getPosition()).isNotEqualTo(Position.createStartPosition());
    }

    @DisplayName("만약 이동 불가능하면 이동하지 않는다.")
    @Test
    public void move_false() {
        Car car = new Car("Thor");
        car.move(nonMovableGenerator);
        assertThat(car.getPosition()).isEqualTo(Position.createStartPosition());
    }

    @DisplayName("같은 위치인지 차량끼리 비교하여 결과를 반환한다.")
    @Test
    public void isSamePosition_true() {
        Car car1 = new Car("Thor");
        Car car2 = new Car("Eden");

        car1.move(movableNumberGenerator);
        car2.move(movableNumberGenerator);

        assertThat(car1.isSamePosition(car2)).isEqualTo(true);
    }

    @DisplayName("다른 위치의 차량끼리 비교하여 결과를 반환한다.")
    @Test
    public void isSamePosition_false() {
        Car car1 = new Car("Thor");
        Car car2 = new Car("Eden");

        car1.move(movableNumberGenerator);

        assertThat(car1.isSamePosition(car2)).isEqualTo(false);
    }
}
