package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.Name;

public class CarTest {

    @ParameterizedTest
    @DisplayName("매직 넘버에대한 자동차 이동")
    @CsvSource(value = {"5, 1", "3, 0", "4, 1", "100, 1"}, delimiter = ',')
    void tryToMoveTest(int input, int expected) {
        final Car car = new Car(new Name("테스트"));
        car.tryToMove(input);
        final int actual = car.getPosition();
        assertThat(actual).isEqualTo(expected);
    }
}
