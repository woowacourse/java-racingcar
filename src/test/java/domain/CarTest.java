package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("Car 생성 테스트")
    void checkConstructor() {

        String expected = "test";
        Car car = new Car(expected);

        String result = car.getName();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Car 이름이 5글자 넘으면 예외발생")
    void checkFailTest() {
        assertThatThrownBy(() -> new Car("testTest"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}