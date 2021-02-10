package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @DisplayName("자동차 이동 메소드 테스트 - 기준값 이상에서 움직임")
    @Test
    public void moveTest() {
        Car car = Car.from("car");
        car.move(DecisionMaker.BASIC_THRESHOLD);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차 이동 메소드 테스트 - 기준값 이하에서 움직이지 않음")
    @Test
    public void notMoveTest() {
        Car car = Car.from("car");
        car.move(DecisionMaker.BASIC_THRESHOLD - 1);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("이름에 따른 equals 테스트")
    @Test
    public void equalsTest() {
        Car car1 = Car.from("car");
        Car car2 = Car.from("car");
        assertThat(car1).isEqualTo(car2);
    }

    @DisplayName("이름 길이 제한으로 인한 예외 발생 테스트")
    @Test
    public void nameLengthExceptionTest() {
        assertThatThrownBy(() -> Car.from("abcdefg")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 position을 기준으로 하는 compare 메소드 테스트")
    @Test
    public void compareTest() {
        Car car1 = Car.from("car1");
        Car car2 = Car.from("car2");
        car2.move(DecisionMaker.BASIC_THRESHOLD);
        assertThat(car1.compareTo(car2)).isEqualTo(-1);
    }
}
