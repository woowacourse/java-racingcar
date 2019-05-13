package racing.control;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceOperatorTest {
    @Test
    void 레이스횟수에따른종료여부() {
        List<String> carNames = Arrays.asList(new String []{"a","b","c","d"});
        int numTrials =5 ;
        RaceOperator raceOperator = new RaceOperator(carNames,numTrials);
        for (int i = 0; i<numTrials-1; i++) {
            raceOperator.doRace();
        }
        assertThat(raceOperator.isEnd()).isTrue();
        raceOperator.doRace();
        assertThat(raceOperator.isEnd()).isFalse();
    }
}
