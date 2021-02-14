package racingcar.controller;

import racingcar.domain.gamemanager.GameManager;
import racingcar.controller.dto.GameManagerResponseDto;
import racingcar.controller.dto.GameManagerRequestDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameManagerController {
    public static void main(String[] args) {
        GameManagerRequestDto requestDto = InputView.inputFromUser();
        GameManagerResponseDto responseDto = new GameManager(requestDto).playGame();
        OutputView.printResults(responseDto);
    }
}
