package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.Car.MINIMUM_NUMBER_TO_MOVE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @DisplayName("Car 객체 생성 시 검증을 통과하면 정상적으로 생성한다.")
    @Test
    void test1() {
        assertThatNoException().isThrownBy(() -> new Car("자동차"));
    }

    @DisplayName("Car 객체 생성 시 이름이 5자 초과이면 예외를 발생시킨다.")
    @Test
    void test2() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("잘못된자동차이름"));
    }

    @DisplayName("Car 객체 생성 시 이름에 공백이 포함되면 예외를 발생시킨다.")
    @Test
    void test3() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(" bad"));
    }

    @DisplayName("move를 위한 최솟값을 만족시키면 position을 1 증가 시킨다.")
    @Test
    void test4() {
        Car car = new Car("any");

        int beforePosition = car.getPosition();
        car.move(MINIMUM_NUMBER_TO_MOVE);
        int afterPosition = car.getPosition();

        assertEquals(beforePosition + 1, afterPosition);
    }

    @DisplayName("move를 위한 최솟값을 만족시키지 못하면 position은 변화하지 않는다.")
    @Test
    void test5() {
        Car car = new Car("any");

        int beforePosition = car.getPosition();
        car.move(MINIMUM_NUMBER_TO_MOVE - 1);
        int afterPosition = car.getPosition();

        assertEquals(beforePosition, afterPosition);
    }
}