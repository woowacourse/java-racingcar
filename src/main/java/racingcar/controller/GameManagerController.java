package racingcar.controller;

import racingcar.domain.gamemanager.GameManager;
import racingcar.domain.result.Results;
import racingcar.domain.gamemanager.dto.GameManagerRequestDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameManagerController {
    public static void main(String[] args) {
        GameManagerRequestDto requestDto = InputView.inputFromUser();
        GameManager gameManager = new GameManager();
        Results results = gameManager.playGame(requestDto);
        OutputView.printResults(results);
        OutputView.printWinners(results);
    }
}
