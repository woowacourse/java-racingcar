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
    @DisplayName("move 메소드를 호출하면 position이 1 증가한다.")
    void moveTest() {
        Car car = new Car("test");

        car.move();

        int position = car.getPosition();
        assertThat(position).isEqualTo(1);
    }
}