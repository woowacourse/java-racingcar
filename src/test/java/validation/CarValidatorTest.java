package validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarValidatorTest {

    @Test
    @DisplayName("차 이름 테스트: 정상 입력")
    void validateCarNames_validInputs() {
        // given
        List<String> names = new ArrayList<>(List.of("A", "bb", "cCc", "DdddD"));

        // when - then
        assertDoesNotThrow(() -> CarValidator.validateCarNames(names));
    }

    @Test
    @DisplayName("차 이름 테스트: 예외 입력(1) - 명명 규칙 위반")
    void validateCarNames_invalidInputs() {
        // given
        List<String> nameTooLong = new ArrayList<>(List.of("abcdef"));
        List<String> nameBlank = new ArrayList<>(List.of(""));
        List<String> nameWithIllegalLetter = new ArrayList<>(List.of("ab!"));
        List<String> nameWithDuplication = new ArrayList<>(List.of("aa,bb,bb,cc"));

        // when - then
        assertThrows(IllegalArgumentException.class,
                () -> CarValidator.validateCarNames(nameTooLong));
        assertThrows(IllegalArgumentException.class,
                () -> CarValidator.validateCarNames(nameBlank));
        assertThrows(IllegalArgumentException.class,
                () -> CarValidator.validateCarNames(nameWithIllegalLetter));
        assertThrows(IllegalArgumentException.class,
                () -> CarValidator.validateCarNames(nameWithDuplication));
    }

    @Test
    @DisplayName("차 대수 테스트: 예외 범위의 차량 대수가 입력")
    void validateCarNums_invalidInputs() {
        // given
        List<String> invalidCarNums = new ArrayList<>();

        //100대가 넘는 차량 대수 생성
        // 테스트 케이스 생성 - [ "A", "AA", "AAA", ... ]
        for (int i = 65; i <= 90; i++) {
            String alphabet = Character.toString((char) i);
            for (int j = 1; j <= 5; j++) {
                invalidCarNums.add(alphabet.repeat(j));
            }
        }

        // when - then
        assertThrows(IllegalArgumentException.class,
                () -> CarValidator.validateCarNames(invalidCarNums));
    }


}
