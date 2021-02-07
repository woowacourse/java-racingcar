package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NamesTest {

    @Test
    void 이름이_중복으로_입력되었을_경우() {
        assertThatThrownBy(() -> {
            String names = "pobi,jun,pobi";
            new Names(names);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("이름이 중복되었습니다");
    }
}
