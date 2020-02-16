package racingcargame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NamesTest {
    @Test
    void null방어로직_확인() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Names(null));
    }

    @Test
    void String인자를_받아_Names객체생성() {
        String string = "라테, 포비";
        Names actual = Names.valueOf(string);
        assertThat(actual).extracting("name").contains("라테");
        assertThat(actual).extracting("name").contains("포비");
    }
}
