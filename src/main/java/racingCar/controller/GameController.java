package racingCar.controller;

import java.util.Scanner;
import racingCar.domain.RacingGame;
import racingCar.utils.ValidateUtils;
import racingCar.view.InputView;
import racingCar.view.OutputView;

public class GameController {

    private final InputView inputView;

    public GameController(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void play() {
        String[] cars = inputCarNames();
        int numOfRacingRound = inputRacingRound();
        RacingGame racingGame = new RacingGame(cars, numOfRacingRound);
        while (!racingGame.isEnd()) {
            racingGame.race();
            OutputView.printCars(racingGame.getCars());
        }
        OutputView.printWinners(racingGame.getWinners());
    }

    private int inputRacingRound() {
        OutputView.printInputNumOfRoundMessage();
        String input = inputView.inputValue();
        try {
            ValidateUtils.validateRacingRoundCount(input);
        } catch (RuntimeException e) {
            OutputView.printExceptionMessage(e);
            inputRacingRound();
        }
        return Integer.parseInt(input);
    }

    private String[] inputCarNames() {
        OutputView.printInputCarNameMessage();
        String[] inputs = inputView.inputCarNames();
        try {
            ValidateUtils.validateCarNames(inputs);
        } catch (RuntimeException e) {
            OutputView.printExceptionMessage(e);
            inputCarNames();
        }
        return inputs;
    }
}
