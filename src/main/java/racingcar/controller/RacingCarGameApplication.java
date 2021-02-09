package racingcar.controller;

import racingcar.domain.GameManager;
import racingcar.domain.Results;
import racingcar.domain.dto.GameManagerRequestDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameApplication {
    public static void main(String[] args) {
        GameManagerRequestDto requestDto = InputView.inputFromUser();
        GameManager gameManager = new GameManager();
        Results results = gameManager.playGame(requestDto);
        OutputView.printResults(results);
        OutputView.printWinners(results);
    }
}
