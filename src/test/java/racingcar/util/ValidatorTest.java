package racingcar.util;

<<<<<<< HEAD
=======
import static org.assertj.core.api.Assertions.assertThatCode;
>>>>>>> 4d9fc51007e7bfca05e14738ad7758fc91ef4071
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @ParameterizedTest
<<<<<<< HEAD
    @ValueSource(strings = {" ", "aaaaa"})
    @DisplayName("차 이름 입력 에러 테스트")
    void carNameFailTest(String carName) {
        assertThatThrownBy(() -> Validator.validateCarNames(carName))
=======
    @ValueSource(strings = {" ", "aaaaaa"})
    @DisplayName("차 이름 입력 에러 테스트")
    void carNameFailTest(String carName) {
        assertThatThrownBy(() -> Validator.validateCarName(carName))
>>>>>>> 4d9fc51007e7bfca05e14738ad7758fc91ef4071
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"gavi", "jude"})
    @DisplayName("차 이름 예외 통과 테스트")
    void carNameSuccessTest(String carName) {
<<<<<<< HEAD
        Validator.validateCarNames(carName);
=======
        assertThatCode(()-> Validator.validateCarName(carName)).doesNotThrowAnyException();
>>>>>>> 4d9fc51007e7bfca05e14738ad7758fc91ef4071
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
<<<<<<< HEAD
        Validator.validateCarName(trial);
=======
        assertThatCode(()-> Validator.validateGameTime(trial)).doesNotThrowAnyException();
>>>>>>> 4d9fc51007e7bfca05e14738ad7758fc91ef4071
    }

}