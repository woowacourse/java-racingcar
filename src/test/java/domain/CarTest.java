package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Car;
import domain.Distance;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("차를 움직이면 거리가 늘어난다.")
    void move() {
        final Car car = Car.of("pobi", 2);

        car.move();

        assertThat(car.getDistance()).isEqualTo(Distance.from(3));
    }
}