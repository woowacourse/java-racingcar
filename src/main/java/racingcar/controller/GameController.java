package racingcar.controller;

import java.util.Scanner;
import racingcar.domain.RacingGame;
import racingcar.utils.ValidateUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private InputView inputView;

    public GameController(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void play() {
        String[] cars = inputCarNames();
        int numOfRacingRound = inputRacingRound();

        OutputView.printRaceResultMessage();
        RacingGame racingGame = new RacingGame(cars, numOfRacingRound);
        while (!racingGame.isEnd()) {
            racingGame.race();
            OutputView.printCars(racingGame.getCars());
        }
        OutputView.printWinners(racingGame.getWinners());
    }

    private int inputRacingRound() {
        try {
            OutputView.printInputNumOfRoundMessage();
            return ValidateUtils.validateRacingRoundCount(inputView.inputValue());
        } catch (RuntimeException e) {
            OutputView.printExceptionMessage(e);
            return inputRacingRound();
        }
    }

    private String[] inputCarNames() {
        try {
            OutputView.printInputCarNameMessage();
            String[] cars = inputView.inputCarNames();
            ValidateUtils.validateCarNames(cars);
            return cars;
        } catch (RuntimeException e) {
            OutputView.printExceptionMessage(e);
            return inputCarNames();
        }
    }
}
