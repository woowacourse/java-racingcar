package racingCar.controller;

import java.util.Scanner;
import racingCar.domain.RacingGame;
import racingCar.utils.ValidateUtils;
import racingCar.view.InputView;
import racingCar.view.OutputView;

public class GameController {

    private InputView inputView;
    private static String[] cars;
    private static int numOfRacingRound;

    public GameController(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void play() {
        inputCarNames();
        inputRacingRound();

        OutputView.printRaceResultMessage();
        RacingGame racingGame = new RacingGame(cars, numOfRacingRound);
        while (!racingGame.isEnd()) {
            racingGame.race();
            OutputView.printCars(racingGame.getCars());
        }
        OutputView.printWinners(racingGame.getWinners());
    }

    private void inputRacingRound() {
        try {
            OutputView.printInputNumOfRoundMessage();
            numOfRacingRound = ValidateUtils.validateRacingRoundCount(inputView.inputValue());
        } catch (RuntimeException e) {
            OutputView.printExceptionMessage(e);
            inputRacingRound();
        }
    }

    private void inputCarNames() {
        try {
            OutputView.printInputCarNameMessage();
            cars = inputView.inputCarNames();
            ValidateUtils.validateCarNames(cars);
        } catch (RuntimeException e) {
            OutputView.printExceptionMessage(e);
            inputCarNames();
        }
    }
}
