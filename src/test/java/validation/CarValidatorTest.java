package validation;

import domain.validation.CarValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"A", "bb", "cCc", "DdddD"})
    @DisplayName("차 이름 테스트: 정상 입력")
    void validateCarNames_validInputs(String validName) {
        assertDoesNotThrow(() -> CarValidator.validateCarNames(List.of(validName)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "", "ab!"})
    @DisplayName("차 이름 테스트: 예외 입력(1) - 명명 규칙 위반")
    void validateCarNames_invalidInputs(String invalidName) {
        List<String> invalidNames = new ArrayList<>(List.of(invalidName));
        assertThrows(IllegalArgumentException.class,
                () -> CarValidator.validateCarNames(invalidNames));
    }

    @Test
    @DisplayName("차 이름 테스트 : 예외 입력(2) - 중복 이름이 존재할 때")
    void validateCarNames_duplicateNames() {
        List<String> duplicateNames = new ArrayList<>(List.of("aa", "bb", "aa"));
        assertThrows(IllegalArgumentException.class,
                () -> CarValidator.validateCarNames(duplicateNames));
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
