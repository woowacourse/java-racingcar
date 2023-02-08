package model.wrapper;

import exception.WrongNameLengthException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    @DisplayName("자동차 이름 길이가 유효하지 않다면 WrongNameLengthException 예외가 발생한다.")
    void wrongNameLengthTest(String wrongInput) {
        Assertions.assertThatThrownBy(() -> new Name(wrongInput))
                .isInstanceOf(WrongNameLengthException.class);
    }
}