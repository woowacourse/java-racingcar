package javaracingcar.controller;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputControllerTest {
    @Test
    void getCarNames_null_입력() {
        assertThatThrownBy(() -> InputController.getCarNames(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null");
    }

    @Test
    void getCarNames_정상입력() {
        String input = ",,A,B,C";
        List<String> names = Arrays.asList("", "", "A", "B", "C");
        assertEquals(InputController.getCarNames(input)
                                    .size(), names.size());
        assertEquals(names, InputController.getCarNames(input));
    }

    @Test
    void getTrial_자연수가아닌경우() {
        assertThatThrownBy(() -> InputController.getTrial("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양의 정수");
        assertThatThrownBy(() -> InputController.getTrial("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양의 정수");
    }

    @Test
    void getTrial_정상입력인경우() {
        assertEquals(InputController.getTrial("30"), 30);
        assertEquals(InputController.getTrial("3"), 3);
    }
}
