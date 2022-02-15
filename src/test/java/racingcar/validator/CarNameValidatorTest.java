package racingcar.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {",", "#", "panda,", "#philz", ",phobi,"})
    @DisplayName("이름에 허용되지 않는 문자가 들어오면 유효성 검사에서 예외 발생")
    public void Not_Available_Character(String input) {
        assertThatThrownBy(
                () -> CarNameValidator.validateCarName(input)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("이름에 null 값이 들어오면 유효성 검사에서 예외 발생")
    public void Not_Available_Null() {
        assertThatThrownBy(
                () -> CarNameValidator.validateCarName(null)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("정상입력")
    public void Available_Character() {
        Assertions.assertDoesNotThrow(() -> {
            CarNameValidator.validateCarName("polo");
        });
    }
}