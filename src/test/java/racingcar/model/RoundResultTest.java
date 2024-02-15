package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundResultTest {

    @DisplayName("가장 멀리 전진한 자동차를 우승자로 선정한다.")
    @Test
    void selectWinner() {
        //given
        LinkedHashMap<String, Integer> moveResult = new LinkedHashMap<>();
        moveResult.put("a", 1);
        moveResult.put("b", 2);
        moveResult.put("c", 1);

        RoundResult roundResult = new RoundResult(moveResult);

        //when
        List<String> winners = roundResult.selectWinners();

        //then
        assertThat(winners).hasSize(1);
        assertThat(winners).containsExactlyInAnyOrder("b");
    }

    @DisplayName("가장 멀리 전진한 횟수가 동일할 경우 우승자는 하나 이상일 수 있다.")
    @Test
    void selectWinners() {
        //given
        LinkedHashMap<String, Integer> moveResult = new LinkedHashMap<>();
        moveResult.put("a", 1);
        moveResult.put("b", 2);
        moveResult.put("c", 2);

        RoundResult roundResult = new RoundResult(moveResult);

        //when
        List<String> winners = roundResult.selectWinners();

        //then
        assertThat(winners).hasSize(2);
        assertThat(winners).containsExactlyInAnyOrder("b", "c");
    }
}