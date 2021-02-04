package javaracingcar.controller;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputControllerTest {
    @Test
    void splitInput_null_입력() {
        assertThatThrownBy(() -> InputController.splitInput(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null");
    }

    @Test
    void splitInput_정상입력() {
        String input = ",,A,B,C";
        List<String> names = Arrays.asList("", "", "A", "B", "C");
        assertEquals(InputController.splitInput(input)
                                    .size(), names.size());
        assertEquals(names, InputController.splitInput(input));
    }

    @Test
    void getTrialInput_자연수가아닌경우() {
        assertThatThrownBy(() -> InputController.getTrialInput("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양의 정수");
        assertThatThrownBy(() -> InputController.getTrialInput("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양의 정수");
    }

    @Test
    void getTrialInput_정상입력인경우() {
        assertEquals(InputController.getTrialInput("30"), 30);
        assertEquals(InputController.getTrialInput("3"), 3);
    }
}
