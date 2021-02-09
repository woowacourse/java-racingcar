package racing.controller;

import racing.domain.Cars;
import racing.domain.RacingGameMachine;
import racing.domain.number.TryCount;
import racing.view.InputScreen;
import racing.view.InputView;

public class RacingController {
    public void run() {
        RacingGameMachine racingGameMachine = initializeRacingGame();
        racingGameMachine.play();
    }

    private RacingGameMachine initializeRacingGame() {
        InputScreen inputScreen = new InputScreen();
        inputScreen.showMessage();
        String carNames = InputView.getNextLine();
        Cars cars = Cars.generate(carNames);
        inputScreen.showCountMessage();
        int tryCount = InputView.getNextInt();
        return new RacingGameMachine(cars, new TryCount(tryCount));
    }
}
