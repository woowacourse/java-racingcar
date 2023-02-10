package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static domain.Car.MINIMUM_NUMBER_TO_MOVE;
import static org.assertj.core.api.Assertions.*;

class CarTest {

    @DisplayName("Car 객체 생성시")
    @Nested
    class create_car {

        @DisplayName("검증을 통과하면 정상적으로 생성한다.")
        @Test
        void success() {
            assertThatNoException().isThrownBy(() -> new Car("자동차"));
        }

        @DisplayName("이름이 5자 초과이면 예외를 발생시킨다.")
        @Test
        void fail_by_name_length_exception() {
            assertThatIllegalArgumentException().isThrownBy(() -> new Car("잘못된자동차이름"));
        }

        @DisplayName("이름에 공백이 포함되면 예외를 발생시킨다.")
        @Test
        void fail_by_contain_blank() {
            assertThatIllegalArgumentException().isThrownBy(() -> new Car(" bad"));
        }
    }

    @DisplayName("move 메소드는 ")
    @Nested
    class move {

        @DisplayName("최솟값을 만족시키면 position을 1 증가 시킨다.")
        @Test
        void success() {
            Car car = new Car("any");

            int beforePosition = car.getPosition();
            car.move(MINIMUM_NUMBER_TO_MOVE);
            int afterPosition = car.getPosition();

            assertThat(afterPosition).isEqualTo(beforePosition+1);
        }

        @DisplayName("최솟값을 만족시키지 못하면 position은 변화하지 않는다.")
        @Test
        void fail() {
            Car car = new Car("any");

            int beforePosition = car.getPosition();
            car.move(MINIMUM_NUMBER_TO_MOVE - 1);
            int afterPosition = car.getPosition();

            assertThat(afterPosition).isEqualTo(beforePosition);
        }
    }

    @DisplayName("isSamePosition 메소드는 ")
    @Nested
    class isSamePosition {

        @DisplayName("position이 같다면 true를 반환한다.")
        @Test
        void return_true() {
            Car carA = new Car("carA");
            Car carB = new Car("carB");

            assertThat(carA.isSamePosition(carB)).isTrue();
        }

        @DisplayName("position이 다르면 false를 반환한다.")
        @Test
        void return_false() {
            Car carA = new Car("carA");
            Car carB = new Car("carB");

            carA.move(MINIMUM_NUMBER_TO_MOVE);

            assertThat(carA.isSamePosition(carB)).isFalse();
        }
    }
}