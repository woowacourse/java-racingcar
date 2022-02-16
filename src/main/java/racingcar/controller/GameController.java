package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;

public class GameController {

    public List<List<Car>> playAndGetRoundResults(Game game) {
        List<List<Car>> roundResults = new ArrayList<>();

        while (!game.isOver()) {
            game.playRound();
            roundResults.add(game.getCars());
        }

        return roundResults;
    }

    public void clearGameData(Game game) {
        game.clearCars();
    }
}
