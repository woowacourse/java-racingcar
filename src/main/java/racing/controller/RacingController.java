package racing.controller;

import racing.domain.Cars;
import racing.domain.RacingGameMachine;
import racing.view.InputView;

public class RacingController {

    public void run() {
        RacingGameMachine racingGameMachine = initializeRacingGame();
        while (racingGameMachine.canPlay()) {
            racingGameMachine.play();
        }
        racingGameMachine.findWinnerNames();
    }

    private RacingGameMachine initializeRacingGame() {
        String carNames = InputView.getNextLine();
        Cars cars = Cars.generate(carNames);
        int tryCounts = InputView.getNextInt();
        return new RacingGameMachine(cars, tryCounts);
    }
}
