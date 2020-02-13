package domain;

import calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarTest {
    @Test
    void isMove_전진_성공() {
        Car car = new Car("타미");
        assertThat(car.move(4)).isTrue();
    }

    @Test
    void isMove_전진_실패() {
        Car car = new Car("타미");
        assertThat(car.move(0)).isFalse();
    }
}
