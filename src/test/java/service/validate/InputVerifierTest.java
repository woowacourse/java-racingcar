package service.validate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.util.Converter;
import racing.validate.InputVerifier;

class InputVerifierTest {

    @DisplayName("자동차 이름 조건 검증")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,aaaaaa", " ", ""})
    void 자동차_이름_검증(String input) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> InputVerifier.validateNameLength(Converter.splitInput(input)));
    }

    @DisplayName("자동차 이름에 공백이 포함된 경우")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,aa aa"})
    void 자동차_이름_공백_포함(String input) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> InputVerifier.validateNameLength(Converter.splitInput(input)));
    }

    @DisplayName("자동차 이름에 공백만 입력된 경우")
    @ParameterizedTest
    @ValueSource(strings = {" "})
    void 자동차_이름_공백만_입력(String input) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> InputVerifier.validateNameLength(Converter.splitInput(input)));
    }

    @DisplayName("자동차 이름에 아무것도 입력받지 않은 경우")
    @ParameterizedTest
    @ValueSource(strings = {""})
    void 자동차_이름_아무것도_입력하지_않음(String input) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> InputVerifier.validateNameLength(Converter.splitInput(input)));
    }
}