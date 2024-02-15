package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarsTest {
    private static CarAccelerator accelerator;

    @BeforeAll
    static void init() {
        accelerator = new CarAccelerator();
    }


    @Test
    @DisplayName("입력받은 자동차의 개수가 2대 이상이면 객체 생성에 성공한다")
    void createCarsSuccess() {
        //given
        Car car1 = new Car("pobi", accelerator);
        Car car2 = new Car("pobi", accelerator);
        List<Car> carInfos = List.of(car1, car2);
        //when
        //then
        Assertions.assertThatCode(() -> new Cars(carInfos, accelerator));
    }

    @Test
    @DisplayName("입력받은 자동차의 개수가 1대 이하이면 객체 생성에 실패한다")
    void createCarsFail() {
        //given
        Car car = new Car("pobi", accelerator);
        List<Car> carInfos = List.of(car);
        //when
        //then
        Assertions.assertThatThrownBy(() -> new Cars(carInfos, accelerator))
                .isInstanceOf(IllegalArgumentException.class);
    }

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