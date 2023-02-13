package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차")
public class CarTest {

    @DisplayName("전진하는 경우")
    @ParameterizedTest
    @ValueSource(ints = {4, 7, 9})
    void moveTrue(int input) {
        Car car = new Car("move");
        car.move(input);

        assertThat(car.getDistance()).isEqualTo(1);
    }

    @DisplayName("전진하는 경우")
    @ParameterizedTest
    @CsvSource(value = {"4:4", "7:7", "100:100"}, delimiter = ':')
    void moveTrue(int input, int expected) {
        Car car = new Car("move");

        IntStream.range(0, input).forEach(moveCount -> car.move(4));

        assertThat(car.getDistance()).isEqualTo(expected);
    }

    @DisplayName("전진하지 않는 경우")
    @ParameterizedTest
    @ValueSource(ints = {0, 2, 3})
    void moveFalse(int input) {
        Car car = new Car("stay");
        car.move(input);

        assertThat(car.getDistance()).isEqualTo(0);
    }

    @DisplayName("공백이 포함되어 글자가 1 ~ 5 글자가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"  pobi   ", "  hello  ", " 제이미짱! "})
    void validateCarNameSuccess(String input) {
        Assertions.assertDoesNotThrow(() -> new Car(input));
    }

    @DisplayName("공백이 포함되어 글자가 1 ~ 5 글자가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"  pobiss   ", "    ", " 제이미짱!! "})
    void validateCarNameFail(String input) {
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차명은 1 ~ 5 글자로 입력해야합니다.");
    }
}
