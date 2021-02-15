package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CarTest {

    @Test
    @DisplayName("Car가 움직였는지를 확인하기")
    public void carNameIncludeNonEngOrNonKOR() {
        String carName = "haha";
        Car car = new Car(new Name(carName));

        car.carMove(4);
        assertThat(car.getPosition()).isEqualTo(0);
        car.carMove(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
