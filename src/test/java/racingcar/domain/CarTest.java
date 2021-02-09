package racingcar.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.input.carname.validator.exception.InvalidCarNameFormatException;

class CarTest {
    @DisplayName("자동차 이름은 1자 이상, 5자 이하의 숫자나 문자로만 구성되어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a1ㄱ", "B3하", "aBㅡ0", "ㅁㅁㅁ", "aaa", "AA", "555"})
    void validCarNames(String carName) {
        Assertions.assertThatCode(() -> new Car(carName))
            .doesNotThrowAnyException();
    }

    @DisplayName("유효하지 않은 자동차 이름 예외")
    @ParameterizedTest
    @ValueSource(strings = {"a1 ㄱ", "B\t3하", "", ",", " ", "-3"})
    void invalidCarNames(String carName) {
        Assertions.assertThatThrownBy(() -> new Car(carName))
            .isInstanceOf(InvalidCarNameFormatException.class);
    }
}