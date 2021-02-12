package racingcar.controller;

import racingcar.domain.gamemanager.GameManager;
import racingcar.controller.dto.GameManagerResponseDto;
import racingcar.controller.dto.GameManagerRequestDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameManagerController {
    public static void main(String[] args) {
        GameManagerRequestDto requestDto = InputView.inputFromUser();
        GameManager gameManager = new GameManager();
        GameManagerResponseDto responseDto = gameManager.playGame(requestDto);
        OutputView.printResults(responseDto);
    }
}
