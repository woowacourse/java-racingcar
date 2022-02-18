package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.MovingCarStrategy;
import racingcar.model.RandomMovingStrategy;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {
    private MovingCarStrategy movingCarStrategy;

    @BeforeEach
    public void beforeEach() {
        movingCarStrategy = new RandomMovingStrategy();
    }

    @Test
    public void 자동차_이름_공백() {
        assertThatThrownBy(() -> new Car(null, movingCarStrategy))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차_이름_null() {
        assertThatThrownBy(() -> new Car("", movingCarStrategy))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차_이름_길이_제한_예외처리() {
        assertThatThrownBy(() -> new Car("배카라쿠네당", movingCarStrategy))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 전진_성공() {
        movingCarStrategy = () -> true;
        Car testCar = new Car("아스피", movingCarStrategy);
        testCar.move();
        assertThat(testCar.isSamePosition(new Car("배카라", 1))).isEqualTo(true);
    }

    @Test
    public void 전진_살패() {
        movingCarStrategy = () -> false;
        Car testCar = new Car("아스피", movingCarStrategy);
        testCar.move();
        assertThat(testCar.isSamePosition(new Car("배카라", 1))).isEqualTo(false);
    }
}
