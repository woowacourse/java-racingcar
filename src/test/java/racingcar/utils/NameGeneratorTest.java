package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NameGeneratorTest {
    @Test
    void 정상입력() {
        Assertions.assertThat(NameGenerator.generateCarNames("pobi,crong,honux"))
                .contains("pobi", "crong", "honux");
    }
}
