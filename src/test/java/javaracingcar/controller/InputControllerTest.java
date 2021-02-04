package javaracingcar.controller;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputControllerTest {

    @Test
    void splitInput_null입력() {
        assertThatThrownBy(() -> InputController.splitInput(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null");
    }

    @Test
    void splitInput_정상입력() {
        String input = ",,A,B,C";
        List<String> names = Arrays.asList("","","A","B","C");
        assertEquals(InputController.splitInput(input).size(), names.size());
        assertEquals(names, InputController.splitInput(input));
    }
}
