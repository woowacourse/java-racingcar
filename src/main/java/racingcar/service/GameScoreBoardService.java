package racingcar.service;

import racingcar.model.score.GameScoreBoard;
import racingcar.model.score.ScoreBoard;
import racingcar.service.converter.ScoreConverter;

import java.util.List;

public class GameScoreBoardService {
    private final GameScoreBoard gameScoreBoard;

    public GameScoreBoardService() {
        this.gameScoreBoard = new GameScoreBoard();
    }

    public void addScoreBoard(int round, List<CarDto> carDtos) {
        gameScoreBoard.add(round, ScoreConverter.of(carDtos));
    }

    public List<ScoreBoard> findScoreBoard() {
        return gameScoreBoard.getScoreBoards();
    }

    public List<String> findWinners() {
        return gameScoreBoard.findWinners();
    }
}
