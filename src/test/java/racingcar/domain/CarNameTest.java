package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"sixsix", "moreThanFive", "", " "})
    @DisplayName("입력이 불가능한 케이스에 대해 예외 발생")
    void exceptionCase(String values) {
        assertThatThrownBy(() -> new CarName(values))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"five5", "1"})
    @DisplayName("정상 입력 케이스에 예외 출력하지 않음")
    void acCase(String values) {
        assertThatCode(() -> new CarName(values))
                .doesNotThrowAnyException();
    }

}
