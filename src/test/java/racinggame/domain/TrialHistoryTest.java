package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class TrialHistoryTest {
    @Test
    void 문자열을_제대로_만드는지_테스트() {
        /* Given */
        final TrialHistory trialHistory = new TrialHistory(Arrays.asList(new Car("pobi", 2),
                new Car("crong", 4)));
        /* Then */
        assertThat(trialHistory.toString()).isEqualTo("pobi : --\ncrong : ----\n");
    }
}