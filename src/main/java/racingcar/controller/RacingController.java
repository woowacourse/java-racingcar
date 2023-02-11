package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.ViewController;

public class RacingController {

    private final ViewController viewController;
    private final RacingService racingService;

    public RacingController() {
        this.viewController = new ViewController();
        this.racingService = new RacingService();
    }

    public void run() {
        setUpCars();
        setUpNumberOfRounds();
        play();
        printWinners();
    }

    private void setUpCars() {
        racingService.makeCars(viewController.getCarNames());
    }

    private void setUpNumberOfRounds() {
        racingService.setNumberOfRounds(viewController.getNumberOfRounds());
    }

    private void play() {
        viewController.startResult();
        while (racingService.isOngoing()) {
            playEachRound();
        }
    }

    private void playEachRound() {
        racingService.playRound();
        viewController.printResult(racingService.getCurrentRoundResult());
    }

    private void printWinners() {
        viewController.printWinners(racingService.getWinners());
    }
}
