package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {

    @DisplayName("자동차 이동 확인 테스트")
    @Test
    void moveTest1() {
        Car car = new Car("bravo", 0);
        car.move(() -> 5);
        int actual = car.getPosition();
        assertThat(actual).isEqualTo(1);
    }

    @DisplayName("자동차 이동 경계값 확인 테스트")
    @Test
    void moveTest2() {
        Car car = new Car("bravo", 0);
        car.move(() -> 4);
        int actual = car.getPosition();
        assertThat(actual).isEqualTo(1);
    }

    @DisplayName("자동차 중지 확인 테스트")
    @Test
    void moveTest3() {
        Car car = new Car("bravo", 0);
        car.move(() -> 3);
        int actual = car.getPosition();
        assertThat(actual).isEqualTo(0);
    }

    @DisplayName("자동차 최대 위치 확인 테스트")
    @Test
    void isMaxPositionTest() {
        Car car = new Car("bravo", 7);
        assertThat(car.isMaxPosition(7)).isTrue();
    }
}
