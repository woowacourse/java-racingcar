package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnersDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class RacingGameController {
    public void start() {
        List<String> names = generateNames();
        int numberOfRounds = generateNumberOfRounds();

        RacingGame racingGame = new RacingGame(new Cars(names), numberOfRounds);

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
        OutputView.printResultMessage();
        while (!racingGame.isFinished()) {
            racingGame.playAnotherRound();
            OutputView.printLeaderBoard(new CarsDto(racingGame.getCars()));
        }
    }
}