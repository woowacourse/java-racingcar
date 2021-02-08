package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacersTest {

    @Test
    void isDuplicated_중복() {
        assertThatThrownBy(() -> {
            String names = "pobi,jun,pobi";
            new Racers(names);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("이름이 중복되었습니다");
    }
}
