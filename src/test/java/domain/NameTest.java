package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @DisplayName("자동차 이름에 대한 예외 발생 테스트")
    @Nested
    class CarNameExceptionTest {

        @DisplayName("자동차 이름이 5자를 넘으면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"abcdef", "가나다라마바사아자"})
        void carNameLengthExceptionTest(String name) {
            assertThatThrownBy(() -> new Name(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("자동차 이름에 공백이나 스페이스를 사용하면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {" ", ""})
        void carNameIsBlankTest(String name) {
            assertThatThrownBy(() -> new Name(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("자동차 이름에 null을 입력하면 예외가 발생한다.")
        @Test
        void carNameIsNullTest() {
            assertThatThrownBy(() -> new Name(null))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("자동차 이름 앞 뒤에 공백이 존재하면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {" pobi", "pobi "})
        void carNameStartsOrEndsWithBlank(String name) {
            assertThatThrownBy(() -> new Name(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("자동차 이름에 영어 또는 한글이 아니면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"pobi1", "123", "..!", "ab."})
        void carNameIsEnglishOrKorean(String name) {
            assertThatThrownBy(() -> new Name(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("올바른 자동차 이름에 대한 성공 테스트")
    @Nested
    class CarNameSuccessTest {

        @DisplayName("자동차 이름이 1~5자 사이라면 예외가 발생하지 않는다.")
        @ParameterizedTest
        @ValueSource(strings = {"a", "abcde"})
        void successTest(String name) {
            assertThatCode(() -> new Name(name))
                    .doesNotThrowAnyException();
        }
    }
}
