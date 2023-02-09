package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "wugawuga"})
    @DisplayName("자동차 생성 시 이름이 한 글자에서 다섯 글자가 아닐 때 예외")
    void validateName(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 최소 1글자, 최대 5글자까지 가능해요.");
    }

    @Test
    @DisplayName("자동차 한 칸 전진 확인")
    void moveCheck() {
        Car car = new Car("밀리");

        car.move(4);

        assertThat(car.isPosition(1)).isTrue();
    }

    @Test
    @DisplayName("자동차 정지 확인")
    void stopCheck() {
        Car car = new Car("밀리");

        car.move(3);

        assertThat(car.isPosition(0)).isTrue();
    }

    @Test
    @DisplayName("더 많이 이동한 자동차 위치 확인")
    void findGreaterPosition() {
        Car car = new Car("밀리");

        car.move(5);
        car.move(5);
        car.move(5);

        assertThat(car.findGreaterPosition(2)).isEqualTo(3);
    }
}