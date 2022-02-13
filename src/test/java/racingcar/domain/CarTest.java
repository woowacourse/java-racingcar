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

    private static final String PARAMETERIZED_TEST_DISPLAY_FORMAT =
        DISPLAY_NAME_PLACEHOLDER + " [" + ARGUMENTS_PLACEHOLDER + "]";
    private static final int CAN_GO_VALUE = 9;

    private Car car;

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

    @DisplayName("isWinner 메서드의 인자 값과 position이 일치하는 경우 참을 반환한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(ints = {1, 3, 10})
    void isWinner_returnTrueIfSame(int winnerPosition) {
        for (int i = 0; i < winnerPosition; i++) {
            car.goOrNot(CAN_GO_VALUE);
        }

        boolean isWinner = car.isWinner(winnerPosition);

        assertThat(isWinner).isTrue();
    }

    @DisplayName("isWinner 메서드의 인자 값과 position이 불일치하는 경우 거짓을 반환한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(ints = {1, 3, 10})
    void isWinner_returnFalseIfDifferent(int winnerPosition) {
        for (int i = 0; i < winnerPosition - 1; i++) {
            car.goOrNot(CAN_GO_VALUE);
        }

        boolean isWinner = car.isWinner(winnerPosition);

        assertThat(isWinner).isFalse();
    }
}
