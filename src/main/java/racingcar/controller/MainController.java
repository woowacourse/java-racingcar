package racingcar.controller;

import racingcar.service.GameService;

public class MainController {
    public void play() {
        GameService.setUpRace();
        GameService.runRace();
        GameService.showWinners();
    }
}