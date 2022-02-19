package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.MovingCarStrategy;
import racingcar.model.RandomMovingStrategy;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {

    @Test
    public void 자동차_이름_공백() {
        MovingCarStrategy movingCarStrategy = new RandomMovingStrategy();
        assertThatThrownBy(() -> new Car(null, movingCarStrategy))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차_이름_null() {
        MovingCarStrategy movingCarStrategy = new RandomMovingStrategy();
        assertThatThrownBy(() -> new Car("", movingCarStrategy))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차_이름_길이_제한_예외처리() {
        MovingCarStrategy movingCarStrategy = new RandomMovingStrategy();
        assertThatThrownBy(() -> new Car("배카라쿠네당", movingCarStrategy))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 전진_성공() {
        MovingCarStrategy movingCarStrategy = () -> true;
        Car testCar = new Car("아스피", movingCarStrategy);
        testCar.move();
        assertThat(testCar.isSamePosition(new Car("배카라", 1))).isEqualTo(true);
    }

    @Test
    public void 전진_실패() {
        MovingCarStrategy movingCarStrategy = () -> false;
        Car testCar = new Car("아스피", movingCarStrategy);
        testCar.move();
        assertThat(testCar.isSamePosition(new Car("배카라", 1))).isEqualTo(false);
    }
}
