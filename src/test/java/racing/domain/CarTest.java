package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("이름이 5글자 초과면 예외")
    void nameLengthEx() {
        assertThatThrownBy(() -> new Car("loooooongName"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("4 이상의 숫자가 들어오면 position은 1 증가한다.")
    void moveTest() {
        Car car = new Car("test");

        car.move(4);

        int position = car.getPosition();
        assertThat(position).isEqualTo(1);
    }

    @Test
    @DisplayName("3 이하의 숫자가 들어오면 position은 증가하지않는다.")
    void notMoveTest() {
        Car car = new Car("test");

        car.move(3);

        int position = car.getPosition();
        assertThat(position).isEqualTo(0);
    }
}
