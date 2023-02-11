package validation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("CarNamesValidation Unit Test")
class CarNamesValidationTest {

    @Test
    @DisplayName("validateInputCarNames() : 이름 5자 초과일 경우에 IllegalArgumentException 발생")
    void test_ValidateName_IllegalArgumentException() {
        //given
        String input = "aaa,bbbb,cccccc";
        String expectedMessage = "자동차 이름은 5자 이하로 작성해주세요.";

        //when & then
        assertThatThrownBy(() -> CarNamesValidation.validateInputCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @Test
    @DisplayName("validateCountOfCars() : 자동차가 한 대 미만일 경우에 IllegalArgumentException 발생")
    void test_validateCountOfCars_IllegalArgumentException() {
        //given
        String input = "";
        String expectedMessage = "자동차를 한 대 이상 작성해주세요.";

        // when & then
        assertThatThrownBy(() -> CarNamesValidation.validateInputCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
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
    @DisplayName("validateDuplicatedCarName() : 자동차 이름이 중복될 경우에 IllegalArgumentException 발생")
    void test_validateDuplicatedCarName_IllegalArgumentException() {
        //given
        String input = "pobi,pobi";
        String expectedMessage = "자동차 이름은 중복되지 않아야합니다.";

        //when & then
        assertThatThrownBy(() -> CarNamesValidation.validateInputCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
}
