package racingcar.service.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.score.Score;
import racingcar.model.score.ScoreBoard;
import racingcar.service.ScoreBoardDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreDtoConverterTest {

    @Test
    @DisplayName("ScoreBoard리스트를 입력 받아서 ScoreBoardDto리스트로 변환한다.")
    void of() {
        List<Score> scores = List.of(new Score("범고래", 1));
        List<ScoreBoard> scoreBoards = List.of(new ScoreBoard(1, scores));
        List<ScoreBoardDto> scoreBoardDtos = ScoreDtoConverter.of(scoreBoards);
        assertThat(scoreBoardDtos.size()).isEqualTo(1);
    }
}