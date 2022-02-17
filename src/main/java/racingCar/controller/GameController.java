package racingCar.controller;

import static racingCar.view.Output.printStartMessage;

import racingCar.controller.service.InputValidator;
import racingCar.controller.service.RacingCarsService;
import racingCar.view.Input;
import racingCar.view.Output;

public class GameController {
    private final RacingCarsService racingCarsService;

    public GameController() {
        String names = InputValidator.validate(Input.inputNames());
        String count = InputValidator.validate(Input.inputCount());
        racingCarsService = new RacingCarsService(names, count);
    }

    public void run() {
        playGame();
        endGame();
    }

    private void playGame() {
        printStartMessage();
        racingCarsService.playGame();
    }

    private void endGame() {
        Output.printWinner(racingCarsService.getWinnerCars());
    }
}