package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"너무 긴 이름", ""})
    void 이름길이_유효성_검사(String input) {
        assertThatThrownBy(() ->
            new Car(input, 0)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자 이하로 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource(value = {"5, 1", "2, 0", "100, 1"}, delimiter = ',')
    void 자동차_전진(int input, int expected) {
        Car car = new Car("테스트", 0);
        car.move(input);
        int actual = car.getPosition();
        assertThat(actual).isEqualTo(expected);
    }
}
