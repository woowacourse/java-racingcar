package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static common.DisplayFormat.PARAMETERIZED_TEST_DISPLAY_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {

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

    @DisplayName("생성자는 인자로 공백 혹은 빈 문자열이 들어오면 예외를 발생시킨다")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"", "  "})
    void constructor_errorOnBlankName(String blankCarName) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Car(blankCarName));
    }

    @DisplayName("생성자는 인자로 5글자를 초과한 문자열이 들어오면 예외를 발생시킨다")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"123456", "carrots"})
    void constructor_errorOnOverFiveLetters(String longName) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Car(longName));
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

    @DisplayName("hasSamePosition 메서드의 인자 값과 position이 일치하는 경우 참을 반환한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(ints = {1, 3, 10})
    void hasSamePosition_returnTrueIfSame(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            car.goOrNot(CAN_GO_VALUE);
        }

        boolean isSame = car.hasSamePosition(moveCount);

        assertThat(isSame).isTrue();
    }

    @DisplayName("hasSamePosition 메서드의 인자 값과 position이 불일치하는 경우 거짓을 반환한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(ints = {1, 3, 10})
    void hasSamePosition_returnFalseIfDifferent(int value) {
        int moveCount = value - 1;
        for (int i = 0; i < moveCount; i++) {
            car.goOrNot(CAN_GO_VALUE);
        }

        boolean isSame = car.hasSamePosition(value);

        assertThat(isSame).isFalse();
    }

    @DisplayName("이름과 포지션이 동일한 Car 인스턴스는 서로 동일한 것으로 간주된다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"ace", "pobi", "jeong"})
    void hashCode_sameNameAndPositionMeansSameInstances(String carName) {
        Car car1 = new Car(carName);
        Car car2 = new Car(carName);

        for (int i = 0; i < carName.length(); i++) {
            car1.goOrNot(CAN_GO_VALUE);
            car2.goOrNot(CAN_GO_VALUE);
        }
        boolean isSame = car1.hashCode() == car2.hashCode();

        assertThat(isSame).isTrue();
    }

    @DisplayName("이름이 다른 Car 인스턴스는 서로 다른 것으로 간주된다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"ace", "pobi", "jeong"})
    void hashCode_differentNameMeansDifferentInstances(String carName) {
        Car car1 = new Car(carName);
        Car car2 = new Car("other");

        for (int i = 0; i < carName.length(); i++) {
            car1.goOrNot(CAN_GO_VALUE);
            car2.goOrNot(CAN_GO_VALUE);
        }
        boolean isSame = car1.hashCode() == car2.hashCode();

        assertThat(isSame).isFalse();
    }
}
