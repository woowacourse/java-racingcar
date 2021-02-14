package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

public class CarTest {

    @Test
    @DisplayName("자동차 객체가 정상적으로 만들어지는지 테스트")
    void carTest() {
        Car car = new Car("mt", 3);
        assertThat(car).isEqualTo(new Car("mt", 3));
    }

    @Test
    @DisplayName("자동차 객체 위치 반환 테스트")
    void carPositionTest() {
        Car car = new Car("mt", 3);
        assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 객체 이름 반환 테스트")
    void carNameTest() {
        Car car = new Car("mt");
        assertThat(car.getName()).isEqualTo("mt");
    }
    
    @Test
    @DisplayName("같은 위치인지 boolean을 반환하는 테스트")
    void carIsEqualPositionTest() {
        Car car = new Car("mt", 3);
        assertThat(car.isEqualPosition(3)).isTrue();
        assertThat(car.isEqualPosition(4)).isFalse();
    }

    @Test
    @DisplayName("숫자에 따른 이동 테스트")
    void carMoveTest() {
        Car car = new Car("mt", 3);
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(3);
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(4);
    }
}
