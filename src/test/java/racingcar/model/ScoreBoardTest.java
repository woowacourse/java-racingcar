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
}
