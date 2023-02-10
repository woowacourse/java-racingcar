package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private static final String DELIMITER = ",";


    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private final RacingGame racingGame;


    public GameController() {
        Cars cars = new Cars(initCars());
        String gameTime = inputView.inputGameTime();
        racingGame = new RacingGame(gameTime, cars);
    }

    private List<Car> initCars() {
        String input = inputView.inputCarName();
        String[] split = input.split(DELIMITER);
        return Arrays.stream(split)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void runGame() {
        for (int i = 0; i < racingGame.getGameTime(); i++) {
            runSingleRound();
        }
    }

    private void runSingleRound() {
        racingGame.moveCars();
        racingGame.getCars().forEach(car -> outputView.printPosition(car.getName(), car.getPosition()));
        System.out.println();
    }

    public void finishGame() {
        List<String> winners = racingGame.calculateWinners();
        racingGame.getCars().forEach(car -> outputView.printPosition(car.getName(), car.getPosition()));
        outputView.printWinners(winners);
    }
}
