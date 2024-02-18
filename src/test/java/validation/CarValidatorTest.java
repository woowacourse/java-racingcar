package validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarValidatorTest {
    //TODO 테스트코드와 내용을 유추할 수 있도록 리팩터링

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
                () -> CarValidator.validateCarNames(nameTooManyCars));
    }


}
