package racingcar.controller;

import racingcar.domain.GameManager;
import racingcar.domain.dto.GameManagerRequestDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameApplication {
    public static void main(String[] args) {
        GameManagerRequestDto requestDto = InputView.inputFromUser();
        GameManager gameManager = new GameManager();
        gameManager.playGame(requestDto);
        OutputView.printResults(gameManager.getResults());
        OutputView.printWinners(gameManager.getWinners());
    }
}
