package racingCar.controller;

import java.util.Scanner;
import racingCar.domain.RacingGame;
import racingCar.utils.ValidateUtils;
import racingCar.view.InputView;
import racingCar.view.OutputView;

public class GameController {

    private InputView inputView;

    public GameController(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void play() {
        String[] carNames = inputCarNames();
        int numOfRacingRound = inputRacingRound();

        RacingGame racingGame = new RacingGame(carNames, numOfRacingRound);
        while (!racingGame.isEnd()) {
            racingGame.race();
            OutputView.printCars(racingGame.getCars());
        }
        OutputView.printWinners(racingGame.getWinners());
    }

    private int inputRacingRound() {
        return ValidateUtils.validateRacingRoundCount(inputView.inputValue());
    }

    private String[] inputCarNames() {
        String[] carNames = inputView.inputCarNames();
        ValidateUtils.validateCarNames(carNames);
        return carNames;
    }


}
