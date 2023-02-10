package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"roy", "hoocu", "sun", "ROO", "Ruca"})
    @DisplayName("영어로 구성된 한 글자 이상 다섯 글자 이하의 문자열이 입력되었을 때, Car 객체가 생성되는지 확인")
    void validate_test(String input) {
        Car car = new Car(input);

        assertThat(car).isInstanceOf(Car.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"코이", "koy1", "royroy", "----", "ㅁdfsㅇ"})
    @DisplayName("영어가 아니거나 범위를 벗어난 문자열이 입력되었을 때, 오류가 발생하는지 확인")
    void validate_error_test(String input) {
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"poby"})
    @DisplayName("Car 객체의 position을 업데이트 했을 때, position이 1이 되었는지 확인")
    void updatePosition_test(String name) {
        Car car = new Car(name);

        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }
}