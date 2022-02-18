package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ScoreBoardTest {
    @Test
    @DisplayName("현재 라운드와 Score리스트를 입력 받아 생성한다.")
    void create() {
        int round = 1;
        List<Score> scores = Arrays.asList(new Score("범고래", 1), new Score("소주캉", 1));

        ScoreBoard scoreBoard = new ScoreBoard(round, scores);
        assertThat(scoreBoard.getRound()).isEqualTo(round);
    }

    @Test
    @DisplayName("point가 가장 높은 Score를 반환한다.")
    void findMaxPoint() {
        List<Score> scores = Arrays.asList(new Score("범고래", 2), new Score("소주캉", 1));
        ScoreBoard scoreBoard = new ScoreBoard(0, scores);
        assertThat(scoreBoard.findMaxScore()).isEqualTo(2);
    }

    @Test
    @DisplayName("point가 가장 높은 Score 이름을 반환한다.")
    void findWinners() {
        List<Score> scores = Arrays.asList(new Score("범고래", 2), new Score("소주캉", 1));
        ScoreBoard scoreBoard = new ScoreBoard(0, scores);
        assertThat(scoreBoard.findWinners()).isEqualTo(List.of("범고래"));
    }
}
