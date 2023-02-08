package controller;

import domain.Car;
import service.GameService;

import java.util.List;

public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public List<Car> getCars(String[] names) {
        return gameService.splitNames(names);
    }
}
