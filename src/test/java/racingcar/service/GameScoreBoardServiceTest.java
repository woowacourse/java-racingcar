package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.score.ScoreBoard;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameScoreBoardServiceTest {
    @Test
    @DisplayName("라운드와 CarDto리스트를 입력하여 저장한다.")
    void addScoreBoard() {
        GameScoreBoardService gameScoreBoardService = new GameScoreBoardService();
        int round = 1;
        String name = "범고래";
        List<CarDto> carDtos = List.of(new CarDto(name));
        gameScoreBoardService.addScoreBoard(round, carDtos);
        assertThat(gameScoreBoardService.findWinners()).isEqualTo(List.of(name));
    }

    @Test
    @DisplayName("스코어 보드를 조회한다.")
    void findScoreBoard() {
        GameScoreBoardService gameScoreBoardService = new GameScoreBoardService();
        int round = 1;
        String name = "범고래";
        List<CarDto> carDtos = List.of(new CarDto(name));
        gameScoreBoardService.addScoreBoard(round, carDtos);
        List<ScoreBoard> scoreBoards = gameScoreBoardService.findScoreBoard();
        ScoreBoard scoreBoard = scoreBoards.get(0);
        assertThat(scoreBoard.getRound()).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자를 조회한다.")
    void findWinners() {
        GameScoreBoardService gameScoreBoardService = new GameScoreBoardService();
        int round = 1;
        List<CarDto> carDtos = List.of(new CarDto("범고래", 1), new CarDto("소주캉", 3));
        gameScoreBoardService.addScoreBoard(round, carDtos);
        assertThat(gameScoreBoardService.findWinners()).containsExactly("소주캉");
    }
}
