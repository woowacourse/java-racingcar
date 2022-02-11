package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.ParameterizedTest.ARGUMENTS_PLACEHOLDER;
import static org.junit.jupiter.params.ParameterizedTest.DISPLAY_NAME_PLACEHOLDER;

public class CarTest {

    final String PARAMETERIZED_TEST_DISPLAY_FORMAT =
            DISPLAY_NAME_PLACEHOLDER + " ["
                    + ARGUMENTS_PLACEHOLDER + "]";

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("jeong");
    }

    @DisplayName("생성자는 인스턴스의 name을 인자로 받은 문자열로, position을 0으로 초기화한다.")
    @Test
    void constructor() {
        String name = "pobi";
        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("goOrNot 메서드는 인자의 값이 4 이상일 경우 position 값을 1만큼 증가시킨다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void goOrNot_move(int num) {
        int prevPosition = car.getPosition();

        car.goOrNot(num);

        assertThat(car.getPosition()).isEqualTo(prevPosition + 1);
    }

    @DisplayName("goOrNot 메서드의 인자의 값이 4 미만일 경우 position 값은 변경되지 않는다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(ints = {0, 1, 2, 3})
    void goOrNot_stay(int num) {
        int prevPosition = car.getPosition();

        car.goOrNot(num);

        assertThat(car.getPosition()).isEqualTo(prevPosition);
    }
}
