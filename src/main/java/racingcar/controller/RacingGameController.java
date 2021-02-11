package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.Round;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnersDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class RacingGameController {
    public void start(Scanner scanner) {
        List<String> names = InputView.takeNameInput(scanner);
        String numberOfRounds = InputView.takeNumberOfRoundsInput(scanner);
        RacingGame racingGame = new RacingGame(new Cars(names), new Round(numberOfRounds));

        playRacingGame(racingGame);

        OutputView.announceWinners(new WinnersDto(racingGame.getWinners()));
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