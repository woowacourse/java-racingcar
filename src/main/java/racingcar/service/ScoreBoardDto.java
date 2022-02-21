package racingcar.service;

import java.util.List;

public class ScoreBoardDto {
    private final List<ScoreDto> scores;

    public ScoreBoardDto(List<ScoreDto> scores) {
        this.scores = scores;
    }

    public List<ScoreDto> getScores() {
        return scores;
    }
}
