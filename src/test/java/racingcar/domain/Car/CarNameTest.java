package racingcar.domain.Car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @ParameterizedTest
    @DisplayName("이름이 빈 문자열이거나 공백이거나 null 일 때 CarName 생성 테스트")
    @MethodSource("provideEmptyAndBlankAndNullTestCase")
    void carNameNullOrEmptyTest(String input) {
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> provideEmptyAndBlankAndNullTestCase() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of((Object) null)
        );
    }
}