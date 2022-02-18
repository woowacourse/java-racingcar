package racingcar.domain;

import static constants.TestConstants.PARAMETERIZED_TEST_DISPLAY_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static racingcar.constants.output.ErrorOutputMessages.ERROR_BLANK_NOT_ALLOWED;
import static racingcar.constants.output.ErrorOutputMessages.ERROR_OVER_FIVE_CHARACTERS;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

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
        assertThat(car.isSamePosition(0)).isTrue();
    }

    @DisplayName("생성자는 name으로 공백 혹은 빈 문자열이 입력되었을 때 예외를 발생시킨다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {" ", "", "   "})
    void constructor_errorOnBlank(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(name))
                .withMessageMatching(ERROR_BLANK_NOT_ALLOWED);
    }

    @DisplayName("생성자는 name으로 5글자를 초과하는 문자열이 입력되었을 때 예외를 발생시킨다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"123456", "carrots"})
    void constructor_errorOnOverFiveCharacters(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(name))
                .withMessageMatching(ERROR_OVER_FIVE_CHARACTERS);
    }

    @DisplayName("goOrNot 메서드는 인자의 값이 4 이상일 경우 position 값을 1만큼 증가시킨다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void goOrNot_move(int num) {
        int prevPosition = 0;

        car.goOrNot(num);

        assertThat(car.isSamePosition(prevPosition + 1)).isTrue();
    }

    @DisplayName("goOrNot 메서드의 인자의 값이 4 미만일 경우 position 값은 변경되지 않는다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(ints = {0, 1, 2, 3})
    void goOrNot_stay(int num) {
        int prevPosition = 0;

        car.goOrNot(num);

        assertThat(car.isSamePosition(prevPosition)).isTrue();
    }

    @DisplayName("isSamePosition 메서드는 인자로 정수가 들어올 경우 해당 정수 현재 Car의 position이 일치하는지 확인한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @CsvSource(value = {"3:true", "4:false"}, delimiter = ':')
    void isSamePosition_int(String position, String result) {
        // given
        Car pobi = new Car("pobi", 3);
        // then
        assertThat(pobi.isSamePosition(Integer.parseInt(position))).isEqualTo(Boolean.parseBoolean(result));
    }

    @DisplayName("isSamePosition 메서드는 인자로 Car 객체가 들어올 경우 해당 정수 현재 Car의 position이 일치하는지 확인한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @CsvSource(value = {"3:true", "4:false"}, delimiter = ':')
    void isSamePosition_carObject(String position, String result) {
        // given
        Car pobi = new Car("pobi", 3);
        Car testCar = new Car("test", Integer.parseInt(position));
        // then
        assertThat(pobi.isSamePosition(testCar)).isEqualTo(Boolean.parseBoolean(result));
    }
}
