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
        Map<Name, Position> history = new HashMap<>();
        history.put(new Name("a"), new Position(4));
        history.put(new Name("b"), new Position(2));
        history.put(new Name("c"), new Position(3));
        history.put(new Name("d"), new Position(4));
        RacingResult racingResult = new RacingResult(history);

        //when
        List<Name> winners = racingResult.pickWinner();

        //then
        assertThat(winners).containsExactlyInAnyOrderElementsOf(List.of(new Name("a"), new Name("d")));
    }

    @DisplayName("최종 우승 자동차 대수가 1대인 경우를 확인한다.")
    @Test
    void checkWinnerWhenWinnerIsOnlyOne() {
        //given
        Map<Name, Position> history = new HashMap<>();
        history.put(new Name("a"), new Position(4));
        history.put(new Name("b"), new Position(2));
        history.put(new Name("c"), new Position(3));
        RacingResult racingResult = new RacingResult(history);

        //when
        List<Name> winners = racingResult.pickWinner();

        //then
        assertThat(winners).containsExactly(new Name("a"));
    }
}