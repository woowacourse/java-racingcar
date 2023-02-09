package validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("CarInfoValidation Unit Test")
class CarInfoValidationTest {

    @Test
    @DisplayName("validationCar() : 이름 5자 초과일 경우에 IllegalArgumentException 발생")
    void test_ValidateName_IllegalArgumentException() {
        //given
        String input = "aaa,bbbb,cccccc";
        String expectedMessage = "자동차 이름은 5자 이상 작성해주세요.";

        //when & then
        try {
            CarInfoValidation.validateCar(input);
        } catch (IllegalArgumentException exception) {
            final String errorMessage = exception.getMessage();

            assertEquals(expectedMessage, errorMessage);
        }
    }

    @Test
    @DisplayName("validationCar() : 자동차가 한 대 미만일 경우에 IllegalArgumentException 발생")
    void test_ValidateLength_IllegalArgumentException() {
        //given
        String input = "";
        String expectedMessage = "자동차를 한 대 이상 작성해주세요.";

        //when & then
        try {
            CarInfoValidation.validateCar(input);
        } catch (IllegalArgumentException exception) {
            final String errorMessage = exception.getMessage();

            assertEquals(expectedMessage, errorMessage);
        }
    }

    @Test
    @DisplayName("validateCar() 성공 경우")
    void test_validateCar_success() {
        // given
        final String input = "pobi,crong,tobi";

        // when, then
        CarInfoValidation.validateCar(input);
    }

    @Test
    @DisplayName("validateDuplicatedCarName() : 자동차 이름이 중복될 경우에 IllegalArgumentException 발생")
    void test_validateDuplicatedCarName_IllegalArgumentException() {
        //given
        String input = "pobi,pobi";
        String expectedMessage = "자동차 이름은 중복되지 않아야합니다.";

        //when & then
        try {
            CarInfoValidation.validateCar(input);
        } catch (IllegalArgumentException exception) {
            final String errorMessage = exception.getMessage();

            assertEquals(expectedMessage, errorMessage);
        }
    }
}