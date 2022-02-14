package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {

    @Test
    public void 자동차_이름_공백() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차_이름_null() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차_이름_길이_제한_예외처리() {
        assertThatThrownBy(() -> new Car("배카라쿠네당"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 전진_성공() {
        Car testCar = new Car("아스피", 2);
        testCar.move(4);
        assertThat(testCar.isSamePosition(new Car("배카라", 3))).isEqualTo(true);
    }

    @Test
    public void 전진_살패() {
        Car testCar = new Car("아스피", 2);
        testCar.move(3);
        assertThat(testCar.isSamePosition(new Car("배카라", 3))).isEqualTo(false);
    }
}
