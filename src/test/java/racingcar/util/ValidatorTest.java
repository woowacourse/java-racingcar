package racingcar.util;


import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", "aaaaa"})
    @DisplayName("차 이름 입력 에러 테스트")
    void carNameFailTest(String carName) {
        assertThatThrownBy(() -> Validator.validateCarNames(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"gavi", "jude"})
    @DisplayName("차 이름 예외 통과 테스트")
    void carNameSuccessTest(String carName) {
        assertThatCode(()-> Validator.validateCarName(carName)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "-5", "글자"})
    @DisplayName("시도 횟수 입력 에러 테스트")
    void trialFailTest(String trial) {
        assertThatThrownBy(() -> Validator.validateGameTime(trial))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "6", "8"})
    @DisplayName("시도 횟수 입력 성공 테스트")
    void trialSuccessTest(String trial) {
        assertThatCode(()-> Validator.validateGameTime(trial)).doesNotThrowAnyException();
    }

}