package service.validate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputVerifierTest {

    @DisplayName("자동차 이름 조건 검증")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,aaaaaa", "pobi,crong,aa aa", " ", ""})
    void 자동차_이름_검증(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> InputVerifier.splitInput(input));
    }

}