package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class InputStringDTOTest {

    @DisplayName("입력이 비어있거나 null 일경우 0 반환")
    @ParameterizedTest
    @CsvSource(value = {",0", "' ',0"})
    void test1(String input, String result) {
        InputStringDTO inputStringDTO = new InputStringDTO(input);
        assertThat(inputStringDTO.getInput()).isEqualTo(result);
    }

    @DisplayName("입력이 비어있거나 null 이 아닌경우 그대로를 반환")
    @Test
    void test2() {
        //given
        String input = "1,2,3";

        //when
        InputStringDTO inputStringDTO = new InputStringDTO(input);

        //then
        assertThat(inputStringDTO.getInput()).isEqualTo(input);
    }

    @DisplayName("String::isEmpty() 테스트")
    @ParameterizedTest
    @CsvSource(value = {"'',true", "' ',false"})
    void isEmptyTest(String input, boolean result) {
        assertThat(input.isEmpty()).isEqualTo(result);
    }
}