package racingCar.controller;

import static racingCar.view.Output.printStartMessage;

import racingCar.controller.service.RacingCarsService;
import racingCar.controller.service.RequestService;
import racingCar.view.Input;
import racingCar.view.Output;

public class GameController {
    private final RacingCarsService racingCarsService = new RacingCarsService();

    public void run() {
        String names = RequestService.requestNames(Input.inputNames());
        racingCarsService.initiateCars(names);
        racingCarsService.initiateCount(RequestService.requestCount(Input.inputCount()));
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