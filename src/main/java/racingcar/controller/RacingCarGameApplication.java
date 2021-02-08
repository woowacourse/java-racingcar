package racingcar.controller;

import racingcar.domain.GameManager;
import racingcar.domain.dto.GameManagerRequestDto;
import racingcar.domain.dto.GameManagerResponseDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameApplication {
    public static void main(String[] args) {
        GameManagerRequestDto requestDto = InputView.inputFromUser();
        GameManager gameManager = new GameManager();
        GameManagerResponseDto responseDto = gameManager.playGame(requestDto);
        OutputView.printResults(responseDto.getResults());
        OutputView.printWinners(responseDto.getWinners());
    }
}
