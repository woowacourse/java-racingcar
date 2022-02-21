package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameGeneratorTest {
    @Test
    void 차_하나_입력() {
        assertThat(NameGenerator.generateCarNames("pobi"))
                .containsExactly("pobi");
    }

    @Test
    void 차_여러개_입력1() {
        assertThat(NameGenerator.generateCarNames("pobi,crong,honux"))
                .containsExactly("pobi", "crong", "honux");
    }

    @Test
    void 차_여러개_입력2() {
        assertThat(NameGenerator.generateCarNames("pobi,crong,"))
                .containsExactly("pobi", "crong", "");
    }
}
