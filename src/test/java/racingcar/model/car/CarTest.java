package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.car.strategy.ForwardMovingStrategy;
import racingcar.model.car.strategy.RandomMovingStrategy;
import racingcar.util.ErrorMessage;

class CarTest {
    @DisplayName("자동차의 현재 위치 형식 테스트")
    @Test
    void currentStateFormatTest() {
        // given
        Car car = new Car("pobi", new ForwardMovingStrategy());
        int expected = 1;

        // when
        int actual = car.getPosition();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("잘못된 자동차 이름으로 생성될 수 없습니다.")
    @Nested
    class InvalidCarNameConstructTest {
        @DisplayName("자동차 이름에는 문자와 숫자만 들어갈 수 있습니다.")
        @ParameterizedTest
        @ValueSource(strings = {"a?ba", ">A!@", "a c"})
        void validateFormatTest(String input) {
            createFailureTest(input, ErrorMessage.INVALID_CAR_NAME_FORMAT.message());
        }

        @DisplayName("자동차 이름은 한글자 이상이어야 합니다.")
        @ParameterizedTest
        @ValueSource(strings = {"  ", ""})
        void validateBlankTest(String input) {
            createFailureTest(input, ErrorMessage.INVALID_CAR_NAME_FORMAT.message());
        }

        @DisplayName("자동차 이름은 다섯글자 이하이어야 합니다.")
        @ParameterizedTest
        @ValueSource(strings = {"abcdef", "1234567"})
        void validateOverLengthTest(String input) {
            createFailureTest(input, ErrorMessage.CAR_NAME_OVER_RANGE.message());
        }

        private void createFailureTest(String testSampleValue, String expectedErrorMessage) {
            assertThatCode(() -> {
                new Car(testSampleValue, new RandomMovingStrategy());
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(expectedErrorMessage);
        }
    }

    @DisplayName("정상적인 형식의 자동차 이름으로 생성되어야 합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "royce", "abc"})
    void generateCarNamesTest(String input) {
        assertThatCode(() -> {
            new Car(input, new RandomMovingStrategy());
        }).doesNotThrowAnyException();
    }

}
