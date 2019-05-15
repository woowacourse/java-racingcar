package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayTest {
    @Test
    void 자동차의_전체_상태를_String으로_반환받는다() {
        List<String> states = Arrays.asList("a : ", "b : ");
        assertThat(new Play("a,b").getCarStates()).isEqualTo(states);
    }
}