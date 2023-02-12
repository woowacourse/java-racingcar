package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static domain.Name.BLANK_CONTAIN_NAME_EXCEPTION_MESSAGE;
import static domain.Name.NAME_LENGTH_EXCEPTION_MESSAGE;
import static org.assertj.core.api.Assertions.*;

class NameTest {

    @DisplayName("Name 생성시")
    @Nested
    class create_car {

        @DisplayName("검증을 통과하면 정상적으로 생성한다.")
        @ParameterizedTest
        @ValueSource(strings = {"car", "name", "me"})
        void success(String rightName) {
            assertThatNoException().isThrownBy(() -> new Name(rightName));
        }

        @DisplayName("이름이 5자 초과이면 예외를 발생시킨다.")
        @ParameterizedTest
        @ValueSource(strings = {"lenSix", "reallyLongName"})
        void fail_by_name_length_exception(String wrongLengthName) {
            assertThatThrownBy(() -> new Name(wrongLengthName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NAME_LENGTH_EXCEPTION_MESSAGE);
        }

        @DisplayName("이름에 공백이 포함되면 예외를 발생시킨다.")
        @ParameterizedTest
        @ValueSource(strings = {" ", " car", "car "})
        void fail_by_contain_blank(String nameContainingBlank) {
            assertThatThrownBy(() -> new Name(nameContainingBlank))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(BLANK_CONTAIN_NAME_EXCEPTION_MESSAGE);
        }
    }
}