package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    private static Accelerator testMoveForwardAccelerator;

    @BeforeAll
    static void init() {
        testMoveForwardAccelerator = new TestMoveForwardAccelerator();
    }


    @Test
    @DisplayName("입력받은 자동차의 개수가 2대 이상이면 객체 생성에 성공한다")
    void createCarsSuccess() {
        //given
        Car car1 = new Car("pobi");
        Car car2 = new Car("pobi");
        List<Car> carInfos = List.of(car1, car2);
        //when
        //then
        Assertions.assertThatCode(() -> new Cars(carInfos, testMoveForwardAccelerator));
    }

    @Test
    @DisplayName("입력받은 자동차의 개수가 1대 이하이면 객체 생성에 실패한다")
    void createCarsFail() {
        //given
        Car car = new Car("pobi");
        List<Car> carInfos = List.of(car);
        //when
        //then
        Assertions.assertThatThrownBy(() -> new Cars(carInfos, testMoveForwardAccelerator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 자동차의 이름에 중복이 있으면 객체 생성에 실패한다")
    void createCarsFailWhenNameDuplicated() {
        //given
        Car car1 = new Car("pobi");
        Car car2 = new Car("pobi");
        List<Car> carInfos = List.of(car1, car2);
        //when
        //then
        Assertions.assertThatThrownBy(() -> new Cars(carInfos, testMoveForwardAccelerator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차들 중 가장 많이 이동한 차량의 Position을 반환한다")
    void getCarsMaxPosition() {
        //given
        CarAccelerator carAccelerator = new CarAccelerator();
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        Car car3 = new Car("honux");

        List<Car> carInfos = List.of(car1, car2, car3);
        Cars cars = new Cars(carInfos, testMoveForwardAccelerator);

        //when
        car1.moveForward(testMoveForwardAccelerator);
        car1.moveForward(testMoveForwardAccelerator);
        car1.moveForward(testMoveForwardAccelerator);

        car2.moveForward(testMoveForwardAccelerator);
        car2.moveForward(testMoveForwardAccelerator);

        car3.moveForward(testMoveForwardAccelerator);

        //then
        Assertions.assertThat(cars.getWinnerPosition()).isEqualTo(3);
    }

    static class TestMoveForwardAccelerator implements Accelerator {

        static final int MOVE = 4;

        @Override
        public int push() {
            return MOVE;
        }
    }
}