package validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    @DisplayName("차 이름 테스트: 정상 입력")
    void validateCarNames_validInputs() {
        // given
        List<String> names = new ArrayList<>(List.of("A", "bb", "cCc", "DdddD"));

        // when - then
        assertDoesNotThrow(() -> Validator.validateCarNames(names));
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
            () -> Validator.validateCarNames(nameTooLong));
        assertThrows(IllegalArgumentException.class,
            () -> Validator.validateCarNames(nameBlank));
        assertThrows(IllegalArgumentException.class,
            () -> Validator.validateCarNames(nameWithIllegalLetter));
        assertThrows(IllegalArgumentException.class,
            () -> Validator.validateCarNames(nameWithDuplication));
    }

    @Test
    @DisplayName("차 이름 테스트: 예외 입력(2) - 차가 100대 넘는 경우")
    void validateCarNames_invalidInputs_tooManyCars() {
        // given
        List<String> nameTooManyCars = new ArrayList<>();

        // 테스트 케이스 생성 - [ "A", "AA", "AAA", ... ]
        for (int i = 65; i <= 90; i++) {
            String alphabet = Character.toString((char) i);
            for (int j = 1; j <= 5; j++) {
                nameTooManyCars.add(alphabet.repeat(j));
            }
        }

        // when - then
        assertThrows(IllegalArgumentException.class,
            () -> Validator.validateCarNames(nameTooManyCars));
    }

    @Test
    @DisplayName("라운드 테스트 : 정상입력")
    void validateRound_validateInputs() {
        // given
        int[] validateInputs = {1, 2, 50, 99, 100};

        // when - then
        for (int validateInput : validateInputs) {
            assertDoesNotThrow(() -> Validator.validateRound(validateInput));
        }
    }

    @Test
    @DisplayName("라운드 테스트 : 예외입력")
    void validateRound_invalidateInputs() {
        // given
        int[] invalidateInputs = {0, -1, 101, 102};

        // when - then
        for (int invalidateInput : invalidateInputs) {
            assertThrows(IllegalArgumentException.class,
                () -> Validator.validateRound(invalidateInput));
        }
    }
}
