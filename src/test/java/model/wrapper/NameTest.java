package model.wrapper;

import exception.BlankNameException;
import exception.WrongNameLengthException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa", "bbbbbbbbb"})
    @DisplayName("자동차 이름 길이가 유효하지 않다면 WrongNameLengthException 예외가 발생한다.")
    void wrongNameLengthTest(String wrongInput) {
        Assertions.assertThatThrownBy(() -> new Name(wrongInput))
                .isInstanceOf(WrongNameLengthException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "             "})
    @DisplayName("자동차 이름에 공백만이 입력된다면 BlankNameException 예외가 발생한다.")
    void blankNameTest(String blankInput) {
        Assertions.assertThatThrownBy(() -> new Name(blankInput))
                .isInstanceOf(BlankNameException.class);
    }
}