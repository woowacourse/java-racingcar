package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.Name.Validator.*;
import static racingcar.exception.ExceptionMessage.*;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @Test
    @DisplayName("이름이 정상적으로 생성되어야 한다.")
    void create_success() {
        // given
        assertThatCode(() -> new Name("car"))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("잘못된 이름이 주어지면 예외가 발생해야 한다.")
    @ValueSource(strings = {"carcar", "", "  "})
    void create_fail(String input) {
        // expect
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("null 값이 주어지면 예외가 발생해야 한다.")
    void create_failIfNull() {
        // expect
        assertThatThrownBy(() -> new Name(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("5글자 이상을 초과하면 예외가 발생한다.")
    void validate_lengthOverThanSix() {
        // expect
        assertThatThrownBy(() -> validateNameLength("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_CAR_NAME_LENGTH.getMessage());
    }

    @ParameterizedTest
    @DisplayName("빈 값이 주어지면 예외가 발생한다.")
    @ValueSource(strings = {"", "   "})
    void validate_blankName(String input) {
        // expect
        assertThatThrownBy(() -> validateBlankName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BLANK_CAR_NAME.getMessage());
    }

    @ParameterizedTest
    @DisplayName("중복된 이름이 검증되어야 한다.")
    @MethodSource("makeDuplicateNames")
    void validate_duplicateNames(String[] input) {
        // expect
        Assertions.assertThatThrownBy(() -> validateDuplicateNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_CAR_NAME.getMessage());
    }

    public static Stream<Arguments> makeDuplicateNames() {
        return Stream.of(
                Arguments.of((Object) new String[]{"car1", "car2", "car1"}),
                Arguments.of((Object) new String[]{"a", "b", "b"}),
                Arguments.of((Object) new String[]{"1", "1", "1"})
        );
    }
}
