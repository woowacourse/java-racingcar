package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("자동차 객체의")
class CarTest {

    private static final int DEFAULT_POSITION = 0;

    @ParameterizedTest
    @ValueSource(strings = {"roy", "hoocu", "sun", "ROO", "Ruca"})
    @DisplayName("생성자에 영어로 구성된 한 글자 이상 다섯 글자 이하의 이름을 입력할 때, 오류가 발생하지 않는지 확인")
    void create_test(final String input) {
        assertDoesNotThrow(() -> new Car(input, DEFAULT_POSITION));
    }

    @ParameterizedTest
    @ValueSource(strings = {"코이", "koy1", "royroy", "----", "ㅁdfsㅇ", "현구막"})
    @DisplayName("생성자에 영어가 아니거나 다섯 글자를 초과한 이름을 입력할 때, 오류가 발생하는지 확인")
    void create_error_test(final String input) {
        assertThatThrownBy(() -> new Car(input, DEFAULT_POSITION))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "2:0", "3:0", "4:1", "9:1"}, delimiter = ':')
    @DisplayName("move 메소드에 power를 입력했을 때, 4를 기준으로 position이 변화하도록 움직이는지 확인")
    void move_test(final int power, final int expectedPosition) {
        String exampleCarName = "hoocu";
        Car car = new Car(exampleCarName, DEFAULT_POSITION);

        car.move(power);
        int actualPosition = car.getPosition();

        assertThat(actualPosition).isEqualTo(expectedPosition);
    }
}
