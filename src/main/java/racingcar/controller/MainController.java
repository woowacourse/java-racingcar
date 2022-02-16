package racingcar.controller;

import racingcar.service.GameService;

public class MainController {
    GameService gameService = new GameService();

    public void play() {
        gameService.setUpRace();
        gameService.runRace();
        gameService.showWinners();
    }
}