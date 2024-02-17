package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    private static final int MOVE_CONDITION = 5;
    private static final int STOP_CONDITION = 3;


    @Test
    @DisplayName("랜덤_숫자가_4_이상인_경우_전진")
    void moveCarTest() {
        Car car = new Car("capy");
        int initDistance = car.getDistance();
        car.moveCar(MOVE_CONDITION);
        int movedDistance = car.getDistance();

        assertThat(movedDistance).isEqualTo(initDistance + 1);
    }

    @Test
    @DisplayName("랜덤_숫자가_3_이하인_경우_정지")
    void stopCarTest() {
        Car car = new Car("capy");
        int initDistance = car.getDistance();
        car.moveCar(STOP_CONDITION);
        int movedDistance = car.getDistance();

        assertThat(movedDistance).isEqualTo(initDistance);
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
}
