package racingCar.controller;

import static racingCar.view.Output.printStartMessage;

import racingCar.controller.service.RacingCarsService;
import racingCar.controller.service.ValidateInputService;
import racingCar.view.Input;
import racingCar.view.Output;

public class GameController {
    private final RacingCarsService racingCarsService;

    public GameController() {
        String names = ValidateInputService.request(Input.inputNames());
        String count = ValidateInputService.request(Input.inputCount());
        racingCarsService = new RacingCarsService(names, count);
    }

    public void run() {
        playGame();
        endGame();
    }

    public void playGame() {
        printStartMessage();
        racingCarsService.playGame();
    }

    public void endGame() {
        Output.printWinner(racingCarsService.getWinnerCars());
    }
}