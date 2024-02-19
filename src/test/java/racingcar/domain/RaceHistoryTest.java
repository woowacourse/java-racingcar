package racingcar.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceHistoryTest {

    @Nested
    class 우승자를_가려낸다 {
        @Test
        void 우승자가_한_명인_경우() {
            //given
            Map<String, Integer> raceResult = new HashMap<>();
            raceResult.put("car1", 3);
            raceResult.put("car2", 2);
            raceResult.put("car3", 1);

            RaceHistory raceHistory = new RaceHistory();
            raceHistory.add(raceResult);

            //when
            final List<String> raceWinners = raceHistory.getFinalWinners();

            //then
            assertThat(raceWinners).containsExactly("car1");
        }

        @Test
        void 우승자가_여러_명인_경우() {
            Map<String, Integer> raceResult = new HashMap<>();
            raceResult.put("car1", 3);
            raceResult.put("car2", 3);
            raceResult.put("car3", 1);

            RaceHistory raceHistory = new RaceHistory();
            raceHistory.add(raceResult);

            //when
            final List<String> raceWinners = raceHistory.getFinalWinners();

            //then
            assertThat(raceWinners).containsOnlyOnceElementsOf(List.of("car1", "car2"));
        }
    }
}