package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    private static String VALID_LENGTH_NAME = "자동차";
    private static String INVALID_LENGTH_NAME = "너무긴자동차";

    @DisplayName("제한 길이 이내의 이름으로 자동차를 생성한다.")
    @Test
    void carGenerateTest() {
        Car car = new Car(VALID_LENGTH_NAME);
        assertThat(car.getName()).isEqualTo(VALID_LENGTH_NAME);
    }

    @DisplayName("이름이 제한된 길이를 초과하여 예외를 던진다.")
    @Test
    void validateCarNameLengthTest() {
        assertThatThrownBy(() -> new Car(INVALID_LENGTH_NAME)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름에 공백을 포함하면 예외를 던진다.")
    @Test
    void validateCarNameBlankTest() {
        assertThatThrownBy(() -> new Car("실패하는 테스트")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차가 전진한다.")
    @Test
    void forwardTest() {
        Car car = new Car("test");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차가 멈춘다.")
    @Test
    void stopTest() {
        Car car = new Car("test");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
