package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalResultTest {

    @DisplayName("마지막 회차 결과에서 우승자를 찾아온다.")
    @Test
    void gerWinner() {
        //given
        List<RoundResult> roundResults = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            LinkedHashMap<String, Integer> moveResult = new LinkedHashMap<>();
            moveResult.put("a", 1);
            moveResult.put("b", 2);
            moveResult.put("c", 2 + i);

            roundResults.add(new RoundResult(moveResult));
        }

        //when
        TotalResult totalResult = new TotalResult(roundResults);
        List<String> winner = totalResult.getWinner();

        //then
        assertThat(winner).hasSize(1);
        assertThat(winner).containsExactlyInAnyOrder("c");
    }
}