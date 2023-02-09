package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "moreThanFive"})
    @DisplayName("차 이름 입력에 대한 예외 테스트")
    void carNameTest(String exceptionCase) {
        assertThatThrownBy(() -> new Car(exceptionCase))
                .isInstanceOf(IllegalArgumentException.class);
    }

}