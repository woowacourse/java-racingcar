package racing.control;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.MovementStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceOperatorTest {

    RaceOperator raceOperator;
    int numTrials;

    @BeforeEach
    public void setUp() {
        List<String> carNames = Arrays.asList(new String[]{"a", "b", "c", "d"});
        numTrials = 5;
        raceOperator = new RaceOperator(carNames, numTrials);
    }

    @Test
    void 자동차수량일치() {
        assertThat(raceOperator.doRace().getCars()).hasSize(4);
    }

    @Test
    void 레이스횟수모두사용() {
        for (int i = 0; i < numTrials; i++) {
            raceOperator.doRace();
        }
        assertThat(raceOperator.isEnd()).isFalse();
    }

    @Test
    void 레이스횟수남음() {
        for (int i = 0; i < numTrials - 1; i++) {
            raceOperator.doRace();
        }
        assertThat(raceOperator.isEnd()).isTrue();
    }
}

