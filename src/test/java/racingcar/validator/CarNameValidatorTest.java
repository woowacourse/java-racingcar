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
    @DisplayName("이름에 허용되지 않는 문자")
    public void Not_Available_Character(String input) {
        assertThatThrownBy(
                () -> CarNameValidator.validateCarName(input)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("이름에 허용되지 않는 문자 : null")
    public void Not_Available_Null() {
        assertThatThrownBy(
                () -> CarNameValidator.validateCarName(null)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("한 번 해보는 정상입력")
    public void Available_Character() {
        Assertions.assertDoesNotThrow(() -> {
            CarNameValidator.validateCarName("polo");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"panda,philz,java", " panda, philz  , java"})
    @DisplayName("자동차 전체 입력 : 정상")
    public void input_all_car_name(String input) {
        Assertions.assertDoesNotThrow(
                () -> CarNameValidator.parseCarNameInputs(input)
        );
    }

    @Test
    @DisplayName("자동차 전체 입력 : 예외")
    public void input_all_car_name_exception() {
        assertThatThrownBy(() -> {
            CarNameValidator.parseCarNameInputs("panda,philz,javajigi");
        });
    }
}