package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnersDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class RacingGameController {
    public void start(Scanner scanner) {
        List<String> names = generateNames(scanner);
        int numberOfRounds = generateNumberOfRounds(scanner);

        RacingGame racingGame = new RacingGame(new Cars(names), numberOfRounds);

        playRacingGame(racingGame);

        OutputView.announceWinners(new WinnersDto(racingGame.getWinners()));
    }

    private List<String> generateNames(Scanner scanner) {
        OutputView.printCarNameInputRequestMessage();
        return InputView.takeNameInput(scanner);
    }

    private int generateNumberOfRounds(Scanner scanner) {
        OutputView.printNumberOfRoundsInputRequestMessage();
        return InputView.takeNumberOfRoundsInput(scanner);
    }

    private void playRacingGame(RacingGame racingGame) {
        OutputView.printResultMessage();
        while (!racingGame.isFinished()) {
            racingGame.playAnotherRound();
            OutputView.printLeaderBoard(createCarsDto(racingGame));
        }
    }

    private CarsDto createCarsDto(RacingGame racingGame) {
        return new CarsDto(racingGame.getCars());
    }
}