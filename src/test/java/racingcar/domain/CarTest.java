package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.testCondition.FalseCondition;
import racingcar.testCondition.TrueCondition;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    @Test
    @DisplayName("이름이_5자_이상인_자동차는_생성할_수_없다")
    void carNameLengthTest() {
        assertThatCode(() -> {
            Car car = new Car("12345");
        }).doesNotThrowAnyException();

        assertThatThrownBy(() -> {
            Car car = new Car("123456");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("이름에_공백을_포함할_수_없다")
    void carNameNoSpaceTest() {
        assertThatCode(() -> {
            Car car = new Car("1234");
        }).doesNotThrowAnyException();

        assertThatThrownBy(() -> {
            Car car = new Car("12 34");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름에 공백을 포함할 수 없습니다.");
    }

    @Test
    @DisplayName("조건이_참일_경우_전진")
    void moveCarTest() {
        Car car = new Car("apple");

        int beforeDistance = car.getDistance();
        car.moveCar(new TrueCondition());
        int afterDistance = car.getDistance();

        assertThat(afterDistance).isEqualTo(beforeDistance + 1);
    }

    @Test
    @DisplayName("조건이_거짓일_경우_정지")
    void stopCarTest() {
        Car car = new Car("apple");

        int beforeDistance = car.getDistance();
        car.moveCar(new FalseCondition());
        int afterDistance = car.getDistance();

        assertThat(afterDistance).isEqualTo(beforeDistance);
    }
}
