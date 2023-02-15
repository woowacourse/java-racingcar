package validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("CarInfoValidation Unit Test")
class DuplicatedCarNameValidationTest {

    @Test
    @DisplayName("validateCar() 성공 경우")
    void test_validateCar_success() {
        // given
        final String input = "pobi,crong,tobi";

        // when & then
        DuplicatedCarNameValidation.validateCar(input);
    }

    @Test
    @DisplayName("validateDuplicatedCarName() : 자동차 이름이 중복될 경우에 IllegalArgumentException 발생")
    void test_validateDuplicatedCarName_IllegalArgumentException() {
        //given
        String input = "pobi,pobi";
        String expectedMessage = "자동차 이름은 중복되지 않아야합니다.";

        //when & then
        assertThatThrownBy(() -> {
            DuplicatedCarNameValidation.validateCar(input);
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessage(expectedMessage);
    }
}
