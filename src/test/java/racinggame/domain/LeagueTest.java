package racinggame.domain;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LeagueTest {
    @Test
    void startRace_메서드가_잘_수행되는지_테스트() {
        /* Given */
        final int totalTrial = 1;

        Cars expectedCars = new Cars(Arrays.asList("a", "b", "c"));
        Cars testCars = new Cars(Arrays.asList("a", "b", "c"));

        LeagueHistory expectedHistory = new LeagueHistory();
        LeagueHistory testHistory;

        final int numberForMoving = 4;
        NumberGenerator constantGenerator = new ConstantGenerator(numberForMoving);

        expectedCars.moveBy(constantGenerator);
        expectedHistory.record(1, expectedCars.makeTrialHistory());

        /* When */
        League league = new League(totalTrial);
        testHistory = league.startRace(testCars, constantGenerator);

        /* Then */
        assertThat(testHistory).isEqualTo(expectedHistory);
    }

    private LeagueHistory getExpectedHistory(int total) {
       expectedCars.moveBy(constantGenerator);
        expectedHistory.record(2, expectedCars.makeTrialHistory());

    }
}