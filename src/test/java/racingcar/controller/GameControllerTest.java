package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameControllerTest {

    @Test
    void split_exceeding_5() {
        assertThatThrownBy(() -> {
            GameController.split("abcdef,a,b");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void split_only_with_delimiter() {
        assertThatThrownBy(() -> {
            GameController.split(",,");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void split_blank_input() {
        assertThatThrownBy(() -> {
            GameController.split("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void split_null() {
        assertThatThrownBy(() -> {
            GameController.split(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}