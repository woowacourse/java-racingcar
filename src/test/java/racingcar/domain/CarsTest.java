package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("입력받은 자동차의 개수가 2대 이상이면 객체 생성에 성공한다")
    void createCarsSuccess() {
        //given
        final Car car1 = new Car("pobi");
        final Car car2 = new Car("crong");
        final List<Car> carInfos = List.of(car1, car2);
        //when
        //then
        assertThatCode(() -> new Cars(carInfos))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력받은 자동차의 개수가 1대 이하이면 객체 생성에 실패한다")
    void createCarsFail() {
        //given
        final Car car = new Car("pobi");
        final List<Car> carInfos = List.of(car);
        //when
        //then
        assertThatThrownBy(() -> new Cars(carInfos))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 자동차의 이름에 중복이 있으면 객체 생성에 실패한다")
    void createCarsFailWhenNameDuplicated() {
        //given
        final Car car1 = new Car("pobi");
        final Car car2 = new Car("pobi");
        final List<Car> carInfos = List.of(car1, car2);
        //when
        //then
        assertThatThrownBy(() -> new Cars(carInfos))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차를 한꺼번 움직일 수 있다.")
    void moveAllCars() {
        //given
        final Car car1 = new Car("pobi");
        final Car car2 = new Car("crong");
        final List<Car> carInfos = List.of(car1, car2);
        final Cars cars = new Cars(carInfos);

        final Accelerator testMoveForwardAccelerator = new TestMoveForwardAccelerator();
        //when
        cars.tryMove(testMoveForwardAccelerator);
        //then
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