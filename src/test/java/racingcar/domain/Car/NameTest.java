package racingcar.domain.Car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car.Exception.NameException;
import racingcar.domain.Car.Exception.NameLengthException;
import racingcar.domain.Car.Exception.NameNullOrEmptyException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NameTest {

    private static Stream<Arguments> provideEmptyAndBlankAndNullTestCase() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of((Object) null)
        );
    }

    private static Stream<Arguments> provideEveryErrorTestCase() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of((Object) null),
                Arguments.of("123456")
        );
    }

    @ParameterizedTest
    @DisplayName("이름이 빈 문자열이거나 공백이거나 null 일 때 Name 생성 테스트")
    @MethodSource("provideEmptyAndBlankAndNullTestCase")
    void carNameNullOrEmptyTest(String input) {
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(NameNullOrEmptyException.class);
    }

    @ParameterizedTest
    @DisplayName("이름이 6글자 이상일 때의 Car 생성 테스트")
    @ValueSource(strings = {"123456"})
    void generate_invalidName(String input) {
        Assertions.assertThatThrownBy(() -> {
            new Car(input);
        }).isInstanceOf(NameLengthException.class);
    }

    @ParameterizedTest
    @DisplayName("빈 문자열, 공백, null, 6글자 이상 한 번에 테스트")
    @MethodSource("provideEveryErrorTestCase")
    void carNameErrorTest(String input) {
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(NameException.class);
    }

    @ParameterizedTest
    @DisplayName("올바른 이름으로 Car 생성 성공 테스트")
    @ValueSource(strings = {"bepoz  ", "12345", " joy", "b ank"})
    void generate_validName(String input) {
        Car car = new Car(input);
        assertThat(car.getName()).isEqualTo(input.trim());
    }
}