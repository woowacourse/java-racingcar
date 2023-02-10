package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("이름이 5글자 초과면 예외")
    void nameLengthEx() {
        assertThatThrownBy(() -> new Car("loooooongName"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("addPosition 메소드를 호출하면 position이 1 증가한다.")
    void moveTest() {
        Car car = new Car("test");

        car.move(4);

        int position = car.getPosition();
        assertThat(position).isEqualTo(1);
    }
}