package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.Car.MAX_NAME_LENGTH;
import static domain.Car.MINIMUM_NUMBER_TO_MOVE;
import static org.assertj.core.api.Assertions.*;

class CarTest {

    @DisplayName("Car 객체 생성 시 검증을 통과하면 정상적으로 생성한다.")
    @Test
    void Car생성_성공() {
        assertThatNoException()
                .isThrownBy(() -> new Car("자동차"));
    }

    @DisplayName("Car 객체 생성 시 이름이 5자 초과이면 예외를 발생시킨다.")
    @Test
    void Car생성_실패_이름길이초과() {
        assertThatThrownBy(() -> new Car("잘못된자동차이름"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다. ");
    }

    @DisplayName("Car 객체 생성 시 이름에 공백이 포함되면 예외를 발생시킨다.")
    @Test
    void Car생성_실패_이름에공백포함() {
        assertThatThrownBy(() -> new Car(" bad"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름에 공백을 포함할 수 없습니다.");
    }

    @DisplayName("move를 위한 최솟값을 만족시키면 position을 1 증가 시킨다.")
    @Test
    void move_증가() {
        Car car = new Car("any");

        int beforePosition = car.getPosition();
        car.move(MINIMUM_NUMBER_TO_MOVE);
        int afterPosition = car.getPosition();

        assertThat(beforePosition + 1).isEqualTo(afterPosition);
    }

    @DisplayName("move를 위한 최솟값을 만족시키지 못하면 position은 변화하지 않는다.")
    @Test
    void move_유지() {
        Car car = new Car("any");

        int beforePosition = car.getPosition();
        car.move(MINIMUM_NUMBER_TO_MOVE - 1);
        int afterPosition = car.getPosition();

        assertThat(beforePosition).isEqualTo(afterPosition);
    }

    @DisplayName("isSamePosition()은 position이 같다면 true를 반환한다.")
    @Test
    void isSamePositioin_true() {
        Car carA = new Car("carA");
        Car carB = new Car("carB");

        assertThat(carA.isSamePosition(carB)).isTrue();
    }

    @DisplayName("isSamePosition()은 position이 다르면 false를 반환한다.")
    @Test
    void isSamePosition_false() {
        Car carA = new Car("carA");
        Car carB = new Car("carB");

        carA.move(MINIMUM_NUMBER_TO_MOVE);

        assertThat(carA.isSamePosition(carB)).isFalse();
    }
}