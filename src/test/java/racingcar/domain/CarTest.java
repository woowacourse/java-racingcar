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
    @DisplayName("이름으로 자동차 생성 테스트")
    void carTest() {
        // given
        Name testName = new Name("test");

        // when
        Car car = new Car(testName);

        // then
        assertThat(car.getName()).isEqualTo(testName);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:1", "3:0"}, delimiter = ':')
    @DisplayName("자동차 전진 테스트")
    void advanceTest(int number, int expected) {
        // given
        Car car = new Car(new Name("test"));

        // when
        car.advance(number);

        // then
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void invalidAdvanceTest(int number) {
        // given
        Car car = new Car(new Name("test"));

        // when && then
        assertThatThrownBy(() -> car.advance(number))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("유효한 범위가 아닙니다.");
    }

    @Test
    @DisplayName("포지션 동일성 테스트")
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
    @DisplayName("포지션이 높은 차가 양수를 반환")
    void comparePosition() {
        // given
        Car car = new Car(new Name("test"));
        Car otherCar = new Car(new Name("other"));

        // when
        car.advance(ADVANCE);

        // then
        assertThat(car.comparePosition(otherCar)).isEqualTo(1);
    }
}
