package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarNameTest {
    @Test
    void 이름_길이가_6이상인_경우_예외발생() {
        final String nameString = "jason11";

        assertThatThrownBy(() -> new CarName(nameString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이하");
    }

    @Test
    void 이름의_빈값_일경우_예외발생() {
        final String nameString = "";

        assertThatThrownBy(() -> new CarName(nameString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름을 입력해주세요!");
    }

    @Test
    void 이름이_null_일경우_예외발생() {
        final String nameString = null;

        assertThatThrownBy(() -> new CarName(nameString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null은 사용할 수 없습니다. String 타입을 사용하세요.");
    }

    @Test
    void 이름_길이가_5글자인경우() {
        final String nameString = "jason";

        assertThatCode(() -> new CarName(nameString))
                .doesNotThrowAnyException();
    }

    @Test
    void 이름_길이가_1글자인경우() {
        final String nameString = "a";

        assertThatCode(() -> new CarName(nameString))
                .doesNotThrowAnyException();
    }
}
