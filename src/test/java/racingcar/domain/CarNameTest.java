package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarNameTest {
    @Test
    void 이름_길이가_6이상인_경우_예외발생() {
        final String nameString = "jason11";

        assertThatThrownBy(() -> new CarName(nameString))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("이하");
    }

    @Test
    void 이름의_길이가_1보다_작은_경우_예외발생() {
        final String nameString = "";

        assertThatThrownBy(() -> new CarName(nameString))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("이상");
    }
}
