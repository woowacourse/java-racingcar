package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarsTest {

    @Test
    @DisplayName("자동차들 중 가장 많이 이동한 차량의 Position을 반환한다")
    void getCarsMaxPosition() {
        //given
        CarAccelerator carAccelerator = new CarAccelerator();
        Car car1 = new Car("pobi", carAccelerator);
        Car car2 = new Car("crong", carAccelerator);
        Car car3 = new Car("honux", carAccelerator);

        List<Car> carInfos = List.of(car1, car2, car3);
        Cars cars = new Cars(carInfos, carAccelerator);

        //when
        car1.moveForward(4);
        car1.moveForward(4);
        car1.moveForward(4);

        car2.moveForward(4);
        car2.moveForward(4);

        car3.moveForward(4);

        //then
        Assertions.assertThat(cars.getCarsMaxPosition()).isEqualTo(3);
    }

}