package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", ""})
    @NullSource
    @DisplayName("Name() : 자동차 이름이 빈칸일 경우 IllegalArgumentException 발생")
    void test_validateEmptyName_IllegalArgumentException(String name) {
        //given
        String expectedMessage = "자동차 이름은 빈칸일 수 없습니다.";

        //when & then
        assertThatThrownBy(() -> {
            Name carName = Name.fromName(name);
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("Name() : 자동차 이름이 5글자 이상일 경우 IllegalArgumentException 발생")
    void test_validateLengthName_IllegalArgumentException() {
        //given
        String name = "abcdef";
        String expectedMessage = "자동차 이름은 1글자 이상 5글자 이하로 작성해주세요.";

        //when & then
        assertThatThrownBy(() -> {
            Name.fromName(name);
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessage(expectedMessage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "abcde"})
    @DisplayName("Name() : 자동차 이름이 빈칸이 아니고, 1글자 이상 5글자 이하일 경우 제대로 생성된다.")
    void test_validateName_success(String name) throws Exception {
        //when & then
        Name createdName = Name.fromName(name);
    }
}
