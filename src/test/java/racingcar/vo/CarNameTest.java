package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.view.ErrorMessage;

class CarNameTest {

    @DisplayName("new CarName() 테스트")
    @Test
    void constructor_test() {
        String carName = "name1";
        CarName name = new CarName(carName);
        assertThat(name.getName()).isEqualTo(carName);
    }

    @ParameterizedTest(name = "{index}: 예외: {1}")
    @MethodSource("provideCarNameAndErrorMessage")
    void constructor_exception_test(String carName, String errorMessage) {
        assertThatThrownBy(() -> new CarName(carName))
                .hasMessageContaining(errorMessage);
    }

    private static Stream<Arguments> provideCarNameAndErrorMessage() {
        return Stream.of(
                Arguments.of("", ErrorMessage.CAR_NAME_EMPTY.getMessage()),
                Arguments.of("abcdef", ErrorMessage.CAR_NAME_TOO_LONG.getMessage())
        );
    }
}
