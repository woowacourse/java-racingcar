package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @Test
    void 이름이_공백으로_들어온경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(" "));
    }

    @Test
    void 이름의_길이가_0인_경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(""));
    }

    @Test
    public void 자동차이름은_5자이하() {
       assertThatIllegalArgumentException()
               .isThrownBy(() -> new Name("joanne"));
    }

}
