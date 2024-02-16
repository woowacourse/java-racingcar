package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalResultTest {

    @DisplayName("마지막 회차 결과에서 우승자를 찾아온다.")
    @Test
    void gerWinner() {
        //given
        TotalResult totalResult = new TotalResult();

        for (int i = 0; i < 3; i++) {
            Map<CarName, Position> moveResult = new LinkedHashMap<>();
            moveResult.put(new CarName("a"), new Position(1));
            moveResult.put(new CarName("b"), new Position(2));
            moveResult.put(new CarName("c"), new Position(2 + i));
            totalResult.addResult(new RoundResult(moveResult));
        }

        //when
        List<String> winner = totalResult.getWinner();

        //then
        assertThat(winner).hasSize(1);
        assertThat(winner).containsExactlyInAnyOrder("c");
    }
}