import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {


    @Test
    @DisplayName("차 객체를 생성한다.")
    void car() {
        assertThatCode(Car::fromEmpty).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("차를 움직이면 거리가 늘어난다.")
    void carMove() {
        Car car = Car.fromEmpty();
        car.move();
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("차 이름의 길이가 1 이상 5이하면 예외를 발생시키지 않는다")
    void validCarName() {
        assertThatCode(() -> Car.fromName("qwey")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("차 이름의 길이가 1 이상 5이하면 예외를 발생시킨다")
    void invalidCarName() {
        assertThatIllegalArgumentException().isThrownBy(() -> Car.fromName("abcdefg"));
    }
}