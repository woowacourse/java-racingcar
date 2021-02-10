package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NameTest {

    @DisplayName("이름 생성 테스트")
    @Test
    public void create() {
        Name name = new Name("pobi");
        assertThat(name).isEqualTo(new Name("pobi"));
    }

}