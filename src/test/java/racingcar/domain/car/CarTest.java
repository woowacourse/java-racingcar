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
    void validate_test_about_word_limit(String input) {
        Car car = new Car(input);

        assertThat(car).isInstanceOf(Car.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"코이", "koy1", "----", "ㅁdfsㅇ"})
    @DisplayName("영어가 아닌 문자열이 입력되었을 때, 오류가 발생하는지 확인")
    void validate_error_test_about_word_limit(String input) {
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 영어로만 구성되어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"royroy", "abcdefg"})
    @DisplayName("글자수가 5이상인 문자열이 입력되었을 때, 오류가 발생하는지 확인")
    void validate_error_test_about_range_limit(String input) {
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 한 글자 이상 다섯 글자 이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"poby"})
    @DisplayName("Car 객체를 이동시켰을 때, position이 1이 되었는지 확인")
    void move_car_test(String name) {
        Car car = new Car(name);

        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }
}