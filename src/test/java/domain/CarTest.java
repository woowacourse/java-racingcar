package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.Car.MINIMUM_NUMBER_TO_MOVE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @DisplayName("Car 객체 생성 시 검증을 통과하면 정상적으로 생성한다.")
    @Test
    void Car생성_성공() {
        assertThatNoException().isThrownBy(() -> new Car("자동차"));
    }

    @DisplayName("Car 객체 생성 시 이름이 5자 초과이면 예외를 발생시킨다.")
    @Test
    void Car생성_실패_이름길이초과() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("잘못된자동차이름"));
    }

    @DisplayName("Car 객체 생성 시 이름에 공백이 포함되면 예외를 발생시킨다.")
    @Test
    void Car생성_실패_이름에공백포함() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(" bad"));
    }

    @DisplayName("move를 위한 최솟값을 만족시키면 position을 1 증가 시킨다.")
    @Test
    void move_증가() {
        Car car = new Car("any");

        int beforePosition = car.getPosition();
        car.move(MINIMUM_NUMBER_TO_MOVE);
        int afterPosition = car.getPosition();

        assertEquals(beforePosition + 1, afterPosition);
    }

    @DisplayName("move를 위한 최솟값을 만족시키지 못하면 position은 변화하지 않는다.")
    @Test
    void move_유지() {
        Car car = new Car("any");

        int beforePosition = car.getPosition();
        car.move(MINIMUM_NUMBER_TO_MOVE - 1);
        int afterPosition = car.getPosition();

        assertEquals(beforePosition, afterPosition);
    }

    @DisplayName("isSamePosition()은 position이 같다면 true를 반환한다.")
    @Test
    void isSamePositioin_true() {
        Car carA = new Car("carA");
        Car carB = new Car("carB");

        assertTrue(carA.isSamePosition(carB));
    }

    @DisplayName("isSamePosition()은 position이 다르면 false를 반환한다.")
    @Test
    void isSamePosition_false() {
        Car carA = new Car("carA");
        Car carB = new Car("carB");

        carA.move(MINIMUM_NUMBER_TO_MOVE);

        assertFalse(carA.isSamePosition(carB));
    }
}