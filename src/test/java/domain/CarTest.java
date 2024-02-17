package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    private static final int MIN_FORWARD_NUMBER = 4;

    @DisplayName("5자 이내 이름으로 자동차를 생성한다.")
    @Test
    void carGenerateTest() {
        assertThatCode(() -> new Car("테스트")).doesNotThrowAnyException();
    }

    @DisplayName("자동차 이름 5자 초과 예외 테스트")
    @Test
    void validateCarNameLengthTest() {
        assertThatThrownBy(() -> new Car("실패하는테스트")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름 공백 포함 예외 테스트")
    @Test
    void validateCarNameBlankTest() {
        assertThatThrownBy(() -> new Car("실패하는 테스트")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 전진 테스트")
    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest()
    void forwardTest(int addNumber) {
        Car car = new Car("test");
        car.move(MIN_FORWARD_NUMBER + addNumber);
        assertThat(car).extracting("forward").isEqualTo(1);
    }

    @DisplayName("자동차 멈춤 테스트")
    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest()
    void stopTest(int addNumber) {
        Car car = new Car("test");
        car.move(MIN_FORWARD_NUMBER - addNumber);
        assertThat(car).extracting("forward").isEqualTo(0);
    }

}