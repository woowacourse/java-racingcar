package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Game;

public class GameController {

    public List<Cars> playAndGetRoundResults(Game game) {
        List<Cars> roundResults = new ArrayList<>();

        while (!game.isOver()) {
            game.playRound();
            roundResults.add(new Cars(game.getCars()));
        }

        return roundResults;
    }

    public void clearGameData(Game game) {
        game.clearCars();
    }
}
