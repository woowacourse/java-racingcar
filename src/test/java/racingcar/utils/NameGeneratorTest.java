package racingcar.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.utils.generator.NameGenerator;

class NameGeneratorTest {
    @Test
    void 정상입력() {
        assertThat(NameGenerator.generateCarNames("pobi,crong,honux"))
                .contains("pobi", "crong", "honux");
    }
}
