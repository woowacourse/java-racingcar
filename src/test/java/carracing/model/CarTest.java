package carracing.model;

import static carracing.view.messages.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("랜덤값이 4 이상으로 주어질 경우 자동차의 position이 1 증가")
    void 랜덤값_4이상이면_전진() {
        //given
        Car car = new Car("pobi");
        Car stoppedCar = new Car("stop");
        //when
        car.move(() -> true);
        //then
        assertThat(car.compareTo(stoppedCar)).isNegative();
    }

    @Test
    @DisplayName("랜덤값이 4 미만으로 주어질 경우 자동차의 position 변화 없음")
    void 랜덤값_4미만이면_멈춤() {
        //given
        Car car = new Car("pobi");
        Car stoppedCar = new Car("stop");
        //when
        car.move(() -> false);
        //then
        assertThat(car.compareTo(stoppedCar)).isZero();
    }
}
