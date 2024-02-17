package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

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
        Car car2 = new Car("crong");
        List<Car> carInfos = List.of(car1, car2);
        //when
        //then
        assertThatCode(() -> new Cars(carInfos))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력받은 자동차의 개수가 1대 이하이면 객체 생성에 실패한다")
    void createCarsFail() {
        //given
        Car car = new Car("pobi");
        List<Car> carInfos = List.of(car);
        //when
        //then
        assertThatThrownBy(() -> new Cars(carInfos))
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
        assertThatThrownBy(() -> new Cars(carInfos))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차를 한꺼번에 움직일 수 있다.")
    void moveAllCars() {
        //given
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        List<Car> carInfos = List.of(car1, car2);
        //when
        Cars cars = new Cars(carInfos);
        cars.tryMove(testMoveForwardAccelerator);
        //then

        //assertAll 쓰기
        assertAll(
                () -> assertThat(cars.getCarsPosition().get("pobi")).isEqualTo(1),
                () -> assertThat(cars.getCarsPosition().get("crong")).isEqualTo(1)
        );
    }

    static class TestMoveForwardAccelerator implements Accelerator {

        static final int MOVE = 4;

        @Override
        public int push() {
            return MOVE;
        }
    }
}