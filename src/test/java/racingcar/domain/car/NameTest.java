package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @DisplayName("네임 생성 테스트")
    @Test
    void createName() {
        Name name = new Name("pobi");

        Assertions.assertThat(new Name("pobi")).isEqualTo(name);
    }
}