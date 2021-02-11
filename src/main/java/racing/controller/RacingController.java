package racing.controller;

import racing.domain.Cars;
import racing.domain.RacingGameMachine;
import racing.domain.name.CarNames;
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
        String inputName = InputView.getNextLine();
        CarNames carNames = CarNames.of(inputName);
        Cars cars = Cars.generate(carNames);
        inputScreen.showCountMessage();
        int tryCount = InputView.getNextInt();
        return new RacingGameMachine(cars, new TryCount(tryCount));
    }
}
