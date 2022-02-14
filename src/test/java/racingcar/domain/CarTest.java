package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest(name = "자동차 전진 - 난수 : {0}")
    @ValueSource(ints = {4, 5, 6})
    public void 자동차_전진(int randomNumber) {
        Car car = Car.createByName("pobi");
        int prevPosition = car.getPosition();
        car.move(randomNumber);
        assertThat(car.getPosition()).isEqualTo(prevPosition + 1);
    }

    @ParameterizedTest(name = "자동차 정지 - 난수 : {0}")
    @ValueSource(ints = {1, 2, 3, -1})
    public void 자동차_정지(int randomNumber) {
        Car car = Car.createByName("pobi");
        int prevPosition = car.getPosition();
        car.move(randomNumber);
        assertThat(car.getPosition()).isEqualTo(prevPosition);
    }

    @Test
    public void 자동차_위치_확인() {
        Car car = Car.createByName("pobi");
        car.move(4);

        assertThat(car.isSamePosition(1)).isTrue();
        assertThat(car.isSamePosition(3)).isFalse();
    }

    @Test
    public void 자동차_이름_확인() {
        Car car = Car.createByName("pobi");
        assertThat(car.isSameName("pobi")).isTrue();
        assertThat(car.isSameName("crong")).isFalse();
    }
}
