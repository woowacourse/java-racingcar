import static org.assertj.core.api.Assertions.assertThatThrownBy;

import model.CarName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CarNameTest {

    @DisplayName("이름 길이 초과에 대한 예외 발생 확인")
    @ParameterizedTest(name = "{0}")
    @CsvSource(value = {"빈 입력 :  ", "5글자 초과 : abcdef"}, delimiter = ':')
    void constructorOver(String caseName, String carName) {
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }


    @DisplayName("0글자이거나 null 대한 예외 발생 확인")
    @ParameterizedTest
    @NullAndEmptySource
    void constructorNull(String carName) {
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
