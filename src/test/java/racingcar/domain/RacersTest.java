package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacersTest {

    @Test
    @DisplayName("중복된 이름이 들어온 경우 예외처리")
    void duplicatedName() {
        assertThatThrownBy(() -> {
            String names = "pobi,jun,pobi";
            new Racers(names);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("이름이 중복되었습니다");
    }
}
