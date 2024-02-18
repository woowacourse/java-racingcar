package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domain.CarName;

class CarNameTest {

    @DisplayName("유효하지 않은 이름 길이에 대한 예외 발생 확인")
    @ParameterizedTest(name = "{0}")
    @CsvSource(value = {"빈 입력 :  ", "5글자 초과 : abcdef"}, delimiter = ':')
    void constructor(String caseName, String carName) {
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
