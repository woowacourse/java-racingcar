package racingcar.domain.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NameTest {
    @Test
    public void 이름에_공백이_들어가면_자동_제거() {
        Name name = new Name("pobi ");
        assertThat(name).isEqualTo(new Name("pobi"));
    }
}