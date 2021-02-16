package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @ParameterizedTest
    @DisplayName("이름 검증 - 성공")
    @CsvSource(value = {"joy,joy", "12345,12345", " 12345 ,12345"})
    void validateName_success(String input, String expected) {
        CarName name = CarName.valueOf(input);

        assertThat(name).hasToString(expected);
    }

    @ParameterizedTest
    @DisplayName("이름 검증 - 실패")
    @ValueSource(strings = {"123456", "12 4 6", "", " "})
    void validateName_success(String input) {
        assertThatThrownBy(() -> CarName.valueOf(input)).isInstanceOf(RuntimeException.class);
    }
}