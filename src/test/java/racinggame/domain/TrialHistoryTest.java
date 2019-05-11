package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrialHistoryTest {

    private TrialHistory trialHistory;

    @BeforeEach
    void setUp() {
        trialHistory = new TrialHistory(Arrays.asList(new Car("pobi", 2),
                new Car("crong", 4)));
    }

    @Test
    void 승자를_제대로_구하는지_테스트() {
        /* When */
        List<String> winners = trialHistory.findWinners();
        /* Then */
        assertTrue(winners.contains("crong"));
        assertFalse(winners.contains("pobi"));
    }

    @Test
    void 문자열을_제대로_만드는지_테스트() {
        /* Then */
        assertThat(trialHistory.toString()).isEqualTo("pobi : --\ncrong : ----\n");
    }
}