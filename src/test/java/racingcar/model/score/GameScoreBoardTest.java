package racingcar.model.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameScoreBoardTest {
    @Test
    @DisplayName("라운드와 ScoreBoard를 입력 받아 저장한다.")
    void add() {
        int round = 1;
        List<Score> scores = Arrays.asList(new Score("범고래", 0), new Score("소주캉", 0));
        GameScoreBoard gameScoreBoard = new GameScoreBoard();
        gameScoreBoard.add(new ScoreBoard(round, scores));
        assertThat(gameScoreBoard.getScoreBoards().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("가장 높은 점수를 가진 우승자를 조회한다.")
    void findWinners() {
        int round = 1;
        List<Score> scores = Arrays.asList(new Score("범고래", 2), new Score("소주캉", 0));
        GameScoreBoard gameScoreBoard = new GameScoreBoard();
        gameScoreBoard.add(new ScoreBoard(round, scores));
        assertThat(gameScoreBoard.findWinners()).isEqualTo(List.of("범고래"));
    }
}
