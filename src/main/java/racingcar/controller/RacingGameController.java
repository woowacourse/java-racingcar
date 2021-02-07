package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnersDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class RacingGameController {

    private static final String COMMA = ",";

    public void start() {
        List<String> names = generateNames();
        int numberOfRounds = generateNumberOfRounds();
        RacingGame racingGame = new RacingGame(names, numberOfRounds);

        playRacingGame(racingGame);

        OutputView.announceWinners(new WinnersDto(racingGame.getWinners()));
    }

    private List<String> generateNames() {
        OutputView.printCarNameInputRequestMessage();
        return InputView.takeNameInput();
    }

    private int generateNumberOfRounds() {
        OutputView.printNumberOfRoundsInputRequestMessage();
        return InputView.takeNumberOfRoundsInput();
    }

    private void playRacingGame(RacingGame racingGame) {
        int round = generateNumberOfRounds();
        OutputView.printResultMessage();
        for (int i = 0; i < round; i++) {
            racingGame.playRound();
            OutputView.printLeaderBoard(new CarsDto(racingGame.getCars()));
        }
    }
}