package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", "aaaaa"})
    @DisplayName("차 이름 예외처리 테스트")
    void carRangeTest(String carName) {
        assertThatThrownBy(() -> Validator.validateCarNames(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "-5", "글자"} )
    @DisplayName("시도 횟수 공백 입력")
    void tryBlank(String trial) {
        assertThatThrownBy(() -> Validator.validateGameTime(trial))
                .isInstanceOf(IllegalArgumentException.class);
    }

}