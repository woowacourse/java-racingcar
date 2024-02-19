package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차가_전진하면_거리가_1이_증가")
    void moveCarTest() {
        Car car = new Car("capy");
        int initDistance = car.getDistance();
        car.move();
        int movedDistance = car.getDistance();

        assertThat(movedDistance).isEqualTo(initDistance + 1);
    }

    @Test
    @DisplayName("자동차_이름이_5자_이하인_경우_통과")
    void validCarName() {
        assertThatCode(() -> new Car("capy"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차_이름이_5자_초과인_경우_에러_발생")
    void invalidCarName() {
        assertThatThrownBy(() -> new Car("capyeeee"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("랜덤_숫자가_4_이상이면_움직임")
    void randomMoveCar() {
        Car car = new Car("capy");
        car.moveRandomly(new TestRandomMoveCondition(4));
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤_숫자가_4_미만이면_정지")
    void randomStopCar() {
        Car car = new Car("capy");
        car.moveRandomly(new TestRandomMoveCondition(3));
        assertThat(car.getDistance()).isEqualTo(0);
    }

    static class TestRandomMoveCondition implements MoveCondition {
        private static final int MINIMUM_MOVEMENT_CONDITION = 4;
        private final int number;

        public TestRandomMoveCondition(int number) {
            this.number = number;
        }

        @Override
        public boolean isMovable() {
            return number >= MINIMUM_MOVEMENT_CONDITION;
        }
    }
}
