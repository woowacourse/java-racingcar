package racingcar.service.converter;

import racingcar.model.score.Score;
import racingcar.model.score.ScoreBoard;
import racingcar.service.ScoreBoardDto;
import racingcar.service.ScoreDto;

import java.util.ArrayList;
import java.util.List;

public class ScoreDtoConverter {
    public static List<ScoreBoardDto> of(List<ScoreBoard> scoreBoards) {
        List<ScoreBoardDto> scoreBoardDtos = new ArrayList<>();
        for (ScoreBoard scoreBoard : scoreBoards) {
            scoreBoardDtos.add(new ScoreBoardDto(toScoreDto(scoreBoard.getScores())));
        }
        return scoreBoardDtos;
    }

    private static List<ScoreDto> toScoreDto(List<Score> score) {
        List<ScoreDto> scoreDtos = new ArrayList<>();
        for (Score value : score) {
            scoreDtos.add(new ScoreDto(value.getName(), value.getPoint()));
        }
        return scoreDtos;
    }
}
