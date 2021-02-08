package racingcar.controller;

import racingcar.domain.GameManager;
import racingcar.domain.dto.GameManagerRequestDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameApplication {
    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        String roundCount = InputView.inputRoundCount();
        GameManagerRequestDto gameManagerRequestDto = new GameManagerRequestDto(carNames, roundCount);
        GameManager gameManager = new GameManager();
        gameManager.playGame(gameManagerRequestDto);
        OutputView.printResults(gameManager.getResults());
        OutputView.printWinners(gameManager.getWinners());
    }
}
