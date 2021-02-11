package javaracingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NameTest {
    @Test
    @DisplayName("null 이름 생성")
    void generateNameWithName_null() {
        assertThatThrownBy(() -> new Name(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "           "})
    @DisplayName("공백으로 구성된 이름 생성")
    void generateName_Blank(String name) {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Benz", " Tes", "Test "})
    @DisplayName("정상 길이의 이름 새성")
    void generateName_ValidLength(String str) {
        Name name = new Name(str);
        assertEquals(new Name(str), name);
        assertEquals(str.trim(), name.toString());
    }

    @Test
    @DisplayName("최대길이 초과 이름 생성")
    void generateName_OverLengthLimit() {
        assertThatThrownBy(() -> new Name("Tuscan"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최대길이를 초과");
    }
}