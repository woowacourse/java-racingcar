package racing.controller;

import racing.domain.Cars;
import racing.domain.RacingGameMachine;
import racing.domain.dto.CarDto;
import racing.view.GameScreen;
import racing.view.InputScreen;
import racing.view.InputView;

import java.util.List;

public class RacingController {

    public void run() {
        RacingGameMachine racingGameMachine = initializeRacingGame();
        GameScreen gameScreen = new GameScreen();
        gameScreen.showMessage();
        while (racingGameMachine.canPlay()) {
            racingGameMachine.play();
            List<CarDto> carDtos = racingGameMachine.getCarDtos();
            gameScreen.showCarStatus(carDtos);
        }
        List<String> winnerNames = racingGameMachine.findWinnerNames();
        gameScreen.showWinners(winnerNames);
    }

    private RacingGameMachine initializeRacingGame() {
        InputScreen inputScreen = new InputScreen();
        inputScreen.showMessage();
        String carNames = InputView.getNextLine();
        Cars cars = Cars.generate(carNames);
        inputScreen.showCountMessage();
        int tryCounts = InputView.getNextInt();
        return new RacingGameMachine(cars, tryCounts);
    }
}
