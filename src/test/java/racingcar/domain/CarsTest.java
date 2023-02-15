package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ExceptionMessage.DUPLICATE_CAR_NAME;

class CarsTest {
    @ParameterizedTest
    @DisplayName("중복된 자동차 이름이 검증되어야 한다.")
    @MethodSource("makeDuplicateNames")
    void validate_duplicateCarNames(String[] input) {
        // expected
        assertThatThrownBy(() -> new Cars(List.of(input)))
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

    @ParameterizedTest
    @DisplayName("중복되지 않는 자동차 이름이 검증되어야 한다.")
    @MethodSource("makeNoDuplicateNames")
    void validate_noDuplicateCarNames(String[] input) {
        // expected
        assertThatCode(() -> new Cars(List.of(input)))
                .doesNotThrowAnyException();
    }

    public static Stream<Arguments> makeNoDuplicateNames() {
        return Stream.of(
                Arguments.of((Object) new String[]{"car1", "car2", "car3"}),
                Arguments.of((Object) new String[]{"a", "b", "c"}),
                Arguments.of((Object) new String[]{"1", "2", "3"})
        );
    }
}
