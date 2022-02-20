package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.vo.Name;

public class CarTest {
    static final int ADVANCE = 5;
    static final int STOP = 3;

    @Test
    @DisplayName("이름으로 자동차 생성를 생성한다")
    void carTest() {
        // given
        Name testName = new Name("test");

        // when
        Car car = new Car(testName);

        // then
        assertThat(car.getName()).isEqualTo(testName);
    }

    @Test
    @DisplayName("움직임이 없는 자동차를 생성한다")
    void newMotionlessCar() {
        // given
        Car car = Car.ZERO_POSITION;

        // when && then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest(name = "power : {0}, position : {1}")
    @CsvSource(value = {"4:1", "3:0"}, delimiter = ':')
    @DisplayName("4이상일 경우에만 자동차는 전진한다")
    void advanceTest(int number, int expected) {
        // given
        Car car = new Car(new Name("test"));

        // when
        car.advance(number);

        // then
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @ParameterizedTest(name = "invalid value : {0}")
    @ValueSource(ints = {-1, 10})
    @DisplayName("0 ~ 9 사이의 숫자로만 자동차 움직임 여부를 판단한다")
    void invalidAdvanceTest(int number) {
        // given
        Car car = new Car(new Name("test"));

        // when && then
        assertThatThrownBy(() -> car.advance(number))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("유효한 범위가 아닙니다.");
    }

    @Test
    @DisplayName("포지션이 같은지 비교한다")
    void equalsPosition() {
        // given
        Car car = new Car(new Name("test"));
        Car otherCar = new Car(new Name("other"));

        // when
        car.advance(ADVANCE);
        otherCar.advance(ADVANCE);

        // then
        assertTrue(car.isEqualPosition(otherCar));
    }

    @Test
    @DisplayName("포지션을 비교하여 높은 자동차를 반환한다")
    void comparePosition() {
        // given
        Car car = new Car(new Name("test"));
        Car otherCar = new Car(new Name("other"));

        // when
        car.advance(ADVANCE);

        // then
        assertThat(car.isGreaterThan(otherCar)).isTrue();
    }
}
