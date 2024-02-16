package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    @DisplayName("정상적인 Car 객체 생성")
    void createCar() {
        assertThatCode(() -> new Car("pobi")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과이면 예외")
    void createCarWithOverSize() {
        assertThatThrownBy(() -> new Car("pobipobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 공백이면 예외")
    void createCarWithEmpty() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("랜덤값이 4이상이면 자동차 전진")
    @ValueSource(ints = {4, 9})
    void moveByMovableNumber(int value) {
        Car car = new Car("pobi");
        car.moveByNumber(value);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("랜덤값이 3이하면 자동차 멈춤")
    @ValueSource(ints = {0, 3})
    void moveByImmovableNumber(int value) {
        Car car = new Car("pobi");
        car.moveByNumber(value);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
