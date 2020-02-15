package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NameTest {
    @Test
    void overFiveCharacterName() {
        assertThatThrownBy(() -> new Name("123455"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 " + Name.MAXIMUM_NAME_LENGTH + "자 이하여야 합니다.");
    }
}