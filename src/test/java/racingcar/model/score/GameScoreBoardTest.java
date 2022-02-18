package racingcar.model.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.score.GameScoreBoard;
import racingcar.model.score.Score;
import racingcar.model.score.ScoreBoard;

import java.util.Arrays;
import java.util.List;

public class GameScoreBoardTest {
    @Test
    @DisplayName("라운드와 ScoreBoard를 입력 받아 저장한다.")
    void add() {
        int round = 1;
        List<Score> scores = Arrays.asList(new Score("범고래", 0), new Score("소주캉", 0));

        GameScoreBoard gameScoreBoard = new GameScoreBoard();
        gameScoreBoard.add(new ScoreBoard(round, scores));
    }
}
