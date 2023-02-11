package validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("CarNamesValidation Unit Test")
class CarNamesValidationTest {

    @Test
    @DisplayName("validateInputCarNames() : 이름 5자 초과일 경우에 IllegalArgumentException 발생")
    void test_ValidateName_IllegalArgumentException() {
        //given
        String input = "aaa,bbbb,cccccc";
        String expectedMessage = "자동차 이름은 5자 이하로 작성해주세요.";

        //when & then
        try {
            CarNamesValidation.validateInputCarNames(input);
        } catch (IllegalArgumentException exception) {
            final String errorMessage = exception.getMessage();

            assertEquals(expectedMessage, errorMessage);
        }
    }

    @Test
    @DisplayName("CarNamesValidation() : 자동차가 한 대 미만일 경우에 IllegalArgumentException 발생")
    void test_ValidateCountOfCar_IllegalArgumentException() {
        //given
        String input = "";
        String expectedMessage = "자동차를 한 대 이상 작성해주세요.";

        //when & then
        try {
            CarNamesValidation.validateInputCarNames(input);
        } catch (IllegalArgumentException exception) {
            final String errorMessage = exception.getMessage();

            assertEquals(expectedMessage, errorMessage);
        }
    }

    @Test
    @DisplayName("validateInputCarNames() 성공 경우")
    void test_validateInputCarNames_success() {
        // given
        final String input = "pobi,crong,tobi";

        // when, then
        CarNamesValidation.validateInputCarNames(input);
    }

    @Test
    @DisplayName("validateInputCarNames() : 자동차 이름이 중복될 경우에 IllegalArgumentException 발생")
    void test_validateInputCarNames_IllegalArgumentException() {
        //given
        String input = "pobi,pobi";
        String expectedMessage = "자동차 이름은 중복되지 않아야합니다.";

        //when & then
        try {
            CarNamesValidation.validateInputCarNames(input);
        } catch (IllegalArgumentException exception) {
            final String errorMessage = exception.getMessage();
            assertEquals(expectedMessage, errorMessage);
        }
    }
}
