package model;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"호기", "재즈아니다", "상돌"})
    @DisplayName("이름이 1글자에서 5글자 사이 정상 입력일 경우 에러 미발생.")
    void isCorrectNameTest(String name) {
        assertThatNoException()
                .isThrownBy(() -> new Name(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "재즈진짜아니다"})
    @DisplayName("이름이 공백이거나 5글자를 초과할 경우 에러를 발생시킨다.")
    void isNotCorrectNameTest(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 1~5글자 사이만 가능합니다.");
    }

}