package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnersDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class RacingGameController {
    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해 주세요.";
    private static final String COMMA = ",";

    public void start() {
        List<String> names = generateNames();
        RacingGame racingGame = new RacingGame(names);

        playRacingGame(racingGame);

        OutputView.announceWinners(new WinnersDto(racingGame.getWinners()));
    }

    private void playRacingGame(RacingGame racingGame) {
        int round = takeRoundInput();
        OutputView.printResultMessage();
        for (int i = 0; i < round; i++) {
            racingGame.playRound();
            OutputView.printLeaderBoard(new CarsDto(racingGame.getCars()));
        }
    }

    private List<String> generateNames() {
        OutputView.printCarNameInputRequestMessage();
        return InputView.takeNameInput();
    }

    //TODO
    // 바로 parseInt 때리지 말고 nextLine으로 받고 검증하는 식으로 로직을 나누자
    // 라운드 인풋을 validate 하는 것은 racingGame에서 해줘야하지 않을까?
    // 그리고 racingGame 생성자에서 라운드 인풋을 받아서 관리하는 것은?
    private int takeRoundInput() {
        try {
            OutputView.printNumberOfRoundsInputRequestMessage();
            return Integer.parseInt(InputView.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }
}