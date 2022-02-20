package racingcar.domain;

import static constants.TestConstants.PARAMETERIZED_TEST_DISPLAY_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static racingcar.constants.output.ErrorOutputMessages.ERROR_BLANK_OR_NULL_NOT_ALLOWED;
import static racingcar.constants.output.ErrorOutputMessages.ERROR_OVER_FIVE_CHARACTERS;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.StubMoveStrategy;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("jeong");
    }

    @DisplayName("생성자는 인스턴스의 name을 인자로 받은 문자열로, position을 0으로 초기화한다.")
    @Test
    void constructor() {
        // given
        String name = "pobi";
        Car car = new Car(name);
        // then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.isSamePosition(0)).isTrue();
    }

    @DisplayName("생성자는 name으로 공백 혹은 빈 문자열이 입력되었을 때 예외를 발생시킨다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {" ", "", "   "})
    void constructor_errorOnBlank(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(name))
                .withMessageMatching(ERROR_BLANK_OR_NULL_NOT_ALLOWED);
    }

    @DisplayName("생성자는 name으로 5글자를 초과하는 문자열이 입력되었을 때 예외를 발생시킨다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"123456", "carrots"})
    void constructor_errorOnOverFiveCharacters(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(name))
                .withMessageMatching(ERROR_OVER_FIVE_CHARACTERS);
    }

    @DisplayName("goOrNot 메서드는 들어온 전략에 따라 canGo() 가 true 이면 position을 1 전진한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @CsvSource(value = {"4,1", "5,1", "6,1", "7,1", "8,1", "9,1"}, delimiter = ',')
    void goOrNot_move(int num, int result) {
        // given
        car.goOrNot(new StubMoveStrategy(1, num));
        // then
        assertThat(car.isSamePosition(result)).isTrue();
    }

    @DisplayName("goOrNot 메서드 인자의 값이 4 미만일 경우 position 값은 변경되지 않는다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(ints = {0, 1, 2, 3})
    void goOrNot_stay(int num) {
        // given
        int prevPosition = 0;
        // when
        car.goOrNot(new StubMoveStrategy(1, num));
        // then
        assertThat(car.isSamePosition(prevPosition)).isTrue();
    }

    @DisplayName("isSamePosition 메서드는 인자로 정수가 들어올 경우 해당 정수 현재 Car의 position이 일치하는지 확인한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @CsvSource(value = {"3:true", "4:false"}, delimiter = ':')
    void isSamePosition_int(int position, boolean result) {
        // given
        Car car = new Car("pobi");
        StubMoveStrategy stubMoveStrategy = new StubMoveStrategy(3, 9, 9, 9);
        // when
        for (int i = 0; i < 3; i++) {
            car.goOrNot(stubMoveStrategy);
        }
        // then
        System.out.println(car);
        assertThat(car.isSamePosition(position)).isEqualTo(result);
    }

    @DisplayName("isSamePosition 메서드는 인자로 Car 객체가 들어올 경우 해당 정수 현재 Car의 position이 일치하는지 확인한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @CsvSource(value = {"3:false", "6:true"}, delimiter = ':')
    void isSamePosition_carObject(int decision, boolean result) {
        // given
        Car pobiCar = new Car("pobi");
        Car testCar = new Car("test");
        StubMoveStrategy pobiCarStubMoveStrategy = new StubMoveStrategy(3, 9, 9, 9);
        StubMoveStrategy testCarStubMoveStrategy = new StubMoveStrategy(3, decision, 9, 9);
        // when
        for (int i = 0; i < 3; i++) {
            pobiCar.goOrNot(pobiCarStubMoveStrategy);
            testCar.goOrNot(testCarStubMoveStrategy);
        }
        // then
        assertThat(pobiCar.isSamePosition(testCar)).isEqualTo(result);
    }
}
