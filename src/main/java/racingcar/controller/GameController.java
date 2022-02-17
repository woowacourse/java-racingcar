package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.GameRepository;

public class GameController {

    private static final GameRepository gameRepository = new GameRepository();

    public void initGame(String carNamesInput, String totalRoundsInput) {
        Game newGame = Game.byUserInput(carNamesInput, totalRoundsInput);
        gameRepository.initGame(newGame);
    }

    public List<Cars> playAndGetRoundResults() {
        Game game = getGame();
        List<Cars> roundResults = new ArrayList<>();

        while (!game.isOver()) {
            game.playRound();
            roundResults.add(new Cars(game.getCars()));
        }

        return roundResults;
    }

    public List<Car> getWinners() {
        return getGame().getWinners();
    }

    public void clearGameData() {
        getGame().clearCars();
    }

    private Game getGame() {
        return gameRepository.getGame();
    }
}
