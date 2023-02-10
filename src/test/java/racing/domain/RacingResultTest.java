package racing.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingResultTest {

    @DisplayName("최종 우승 자동차 대수가 2대 이상인 경우를 확인한다.")
    @Test
    void checkWinner() {
        //given
        Map<String, Integer> history = new HashMap<>();
        history.put("a",4);
        history.put("b",2);
        history.put("c",3);
        history.put("d",4);
        RacingResult racingResult = new RacingResult(history);

        //when
        List<String> winners = racingResult.getWinner();

        //then
        assertThat(winners).isEqualTo(List.of("a","d"));
    }

    @DisplayName("최종 우승 자동차 대수가 1대인 경우를 확인한다.")
    @Test
    void checkWinnerWhenWinnerIsOnlyOne() {
        //given
        Map<String, Integer> history = new HashMap<>();
        history.put("a",4);
        history.put("b",2);
        history.put("c",3);
        RacingResult racingResult = new RacingResult(history);

        //when
        List<String> winners = racingResult.getWinner();

        //then
        assertThat(winners).isEqualTo(List.of("a"));
    }
}