package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    private static final MovingStrategy ALWAYS_MOVING_STRATEGY = () -> true;

    @DisplayName("자동차 객체의 유효한 이름 형식은 5자 이하의 영어로 구성되며, 위치 초기값은 0이다.")
    @Test
    void makeCar() {
        assertThatCode(() -> {
            Car car = new Car("pobi", ALWAYS_MOVING_STRATEGY);
            String name = car.getName();
            int position = car.getPosition();

            assertThat(name).isEqualTo("pobi");
            assertThat(position).isZero();
        }).doesNotThrowAnyException();
    }

    @DisplayName("자동차 객체의 이름이 null, 빈문자열, 영어가 아닌 문자 포함, 6자 이상의 영문자인 경우 생성 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"abcdef", "ab.de", "   "})
    void cannotMakeCar(String name) {
        assertThatThrownBy(() -> {
            new Car(name, ALWAYS_MOVING_STRATEGY);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 문자열이 아닌 5자 이하의 영어로 구성되어야 합니다.");
    }

    @DisplayName("자동차 객체가 항상 이동하는 전략을 가지면 move 요청시 위치가 증가한다")
    @Test
    void moveCarAlways() {
        MovingStrategy alwaysMovingStrategy = () -> true;
        Car car = new Car("dummy", alwaysMovingStrategy);

        car.move();
        int position = car.getPosition();

        assertThat(position).isEqualTo(1);
    }

    @DisplayName("자동차 객체가 항상 이동하지 않는 전략을 가지면 move 요청시 움직이지 않는다")
    @Test
    void moveCarNever() {
        MovingStrategy neverMovingStrategy = () -> false;
        Car car = new Car("dummy", neverMovingStrategy);

        int position = car.getPosition();

        assertThat(position).isZero();
    }

    @DisplayName("두 자동차 객체의 위치가 같으면 true를 반환한다")
    @Test
    void isSamePosition() {
        Car car = new Car("pobi", ALWAYS_MOVING_STRATEGY);
        Car target = new Car("brown", ALWAYS_MOVING_STRATEGY);

        boolean isSamePosition = car.isSamePosition(target);

        assertThat(isSamePosition).isTrue();
    }

    @DisplayName("두 자동차 객체의 위치가 다르면 false를 반환한다")
    @Test
    void isDifferentPosition() {
        Car car = new Car("pobi", ALWAYS_MOVING_STRATEGY);
        Car target = new Car("brown", ALWAYS_MOVING_STRATEGY);

        target.move();
        boolean isSamePosition = car.isSamePosition(target);

        assertThat(isSamePosition).isFalse();
    }
}
