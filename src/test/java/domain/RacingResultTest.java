package domain;

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
        Map<String, Integer> history = new HashMap<>();
        history.put("a", 4);
        history.put("b", 2);
        history.put("c", 3);
        history.put("d", 4);
        RacingResult racingResult = new RacingResult(history);

        List<String> winners = racingResult.getWinner();

        assertThat(winners).isEqualTo(List.of("a", "d"));
    }

    @DisplayName("최종 우승 자동차 대수가 1대인 경우를 확인한다.")
    @Test
    void checkWinnerWhenWinnerIsOnlyOne() {
        Map<String, Integer> history = new HashMap<>();
        history.put("a", 4);
        history.put("b", 2);
        history.put("c", 3);
        RacingResult racingResult = new RacingResult(history);

        List<String> winners = racingResult.getWinner();

        assertThat(winners).isEqualTo(List.of("a"));
    }

    @DisplayName("우승한 자동차를 불러올때 기록이 없는 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenResultIsEmpty() {
        Map<String, Integer> history = new HashMap<>();

        RacingResult racingResult = new RacingResult(history);

        assertThatThrownBy(() -> racingResult.getWinner())
                .isInstanceOf(IllegalArgumentException.class);
    }
}