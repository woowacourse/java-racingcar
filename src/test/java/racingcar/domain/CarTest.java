package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class CarTest {

    @DisplayName("이름의 길이가 유효하지 않는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "abcdefg"})
    void expectInvalidLengthExceptionTest(String name) {
        assertThatThrownBy(() ->
                Car.createByName(Name.create(name)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름으로 null이 입력된 경우")
    @ParameterizedTest
    @NullSource
    void expectNullExceptionTest(String name) {
        assertThatThrownBy(() ->
                Car.createByName(Name.create(name)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 유효한 경우의 Car 객체 생성")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "jin", "corgi"})
    void checkInstanceWithValidName(String name) {
        Car.createByName(Name.create(name));
    }
}
