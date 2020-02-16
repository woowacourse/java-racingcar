package racingcar;

import java.util.List;

import racingcar.controller.RacingStadium;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.Winner;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        runApplication();
    }

    private static void runApplication() {
        try {
            final String[] inputCarNames = RacingGame.generateRacingCarNames();
            final List<Car> racingCars = RacingGame.generateCars(inputCarNames);
            final int GameRound = RacingGame.generateGameRound();

            RacingGame racingGame = new RacingGame(racingCars);
            RacingStadium racingStadium = new RacingStadium();
            racingStadium.startRace(GameRound, racingGame);

            Winner winner = new Winner();
            final List<String> winners = winner.findWinners(racingCars);
            OutputView.printWinners(winners);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            runApplication();
        }
    }
}
