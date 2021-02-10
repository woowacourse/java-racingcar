package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NamesTest {

    @Test
    void 이름이_중복으로_입력되었을_경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Names("pobi,jun,pobi"));
    }
}
