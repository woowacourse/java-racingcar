package domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @DisplayName("자동차 이름에 대한 예외 발생 테스트")
    @Nested
    class CarCarNameExceptionTest {

        @DisplayName("자동차 이름이 5자를 넘으면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"abcdef", "가나다라마바사아자"})
        void carNameLengthExceptionTest(String name) {
            assertThatThrownBy(() -> new CarName(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("자동차 이름에 공백이나 스페이스를 사용하면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {" ", ""})
        void carNameIsBlankTest(String name) {
            assertThatThrownBy(() -> new CarName(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("자동차 이름 앞 뒤에 공백이 존재하면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {" pobi", "pobi "})
        void carNameStartsOrEndsWithBlankTest(String name) {
            assertThatThrownBy(() -> new CarName(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("올바른 자동차 이름에 대한 성공 테스트")
    @Nested
    class CarNameSuccessTest {

        @DisplayName("자동차 이름이 1~5자 사이라면 예외가 발생하지 않는다.")
        @ParameterizedTest
        @ValueSource(strings = {"a", "abcde"})
        void validNameTest(String name) {
            assertThatCode(() -> new CarName(name))
                    .doesNotThrowAnyException();
        }
    }
}
