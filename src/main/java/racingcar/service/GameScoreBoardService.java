package racingcar.service;

import racingcar.model.score.GameScoreBoard;
import racingcar.service.converter.ScoreConverter;
import racingcar.service.converter.ScoreDtoConverter;

import java.util.List;

public class GameScoreBoardService {
    private final GameScoreBoard gameScoreBoard;

    public GameScoreBoardService() {
        this.gameScoreBoard = new GameScoreBoard();
    }

    public void addScoreBoard(int round, List<CarDto> carDtos) {
        gameScoreBoard.add(round, ScoreConverter.of(carDtos));
    }

    public List<String> findWinners() {
        return gameScoreBoard.findWinners();
    }

    public List<ScoreBoardDto> findScoreBoard() {
        return ScoreDtoConverter.of(gameScoreBoard.getScoreBoards());
    }
}
