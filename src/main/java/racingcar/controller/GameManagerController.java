package racingcar.controller;

import racingcar.domain.GameManager;
import racingcar.domain.dto.GameManagerRequestDto;
import racingcar.view.InputView;

public class GameManagerController {
    public void run() {
        String[] carNames = getInputCarNames();
        int roundCount = getInputRoundCount();
        GameManagerRequestDto gameManagerRequestDto = new GameManagerRequestDto(carNames, roundCount);
        GameManager gameManager = new GameManager();
        gameManager.playGame(gameManagerRequestDto);
    }

    private String[] getInputCarNames() {
        String input = InputView.inputCarNames();
        String[] carNames = input.split(",");
        return carNames;
    }

    private int getInputRoundCount() {
        return InputView.inputRoundCount();
    }
}
