package javaracingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {
    @Test
    @DisplayName("시도 횟수 입력 테스트 실패 : 양의 정수가 아닌 문자 혹은 음의 정수 입력")
    void init_NotPositiveInteger_ExceptionThrown() {
        assertThatThrownBy(() -> Game.init("a, b, c", "efg"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("양의 정수");
        assertThatThrownBy(() -> Game.init("a, b, c", "-1"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("양의 정수");
    }

    @Test
    @DisplayName("시도 횟수 입력 실패 : Null 입력")
    void init_Null_ExceptionThrown() {
        assertThatThrownBy(() -> Game.init("a,b,c",null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("null");
    }
}