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
    private static final int MAX_GAME_TIME = 500;

    private final Cars cars;
    private final int gameTime;


    public GameController() {
        this.cars = new Cars(initCars());
        String gameTime = inputView.inputGameTime();
        int parsedGameTime = validateParsing(gameTime);
        validateMaxGameTime(parsedGameTime);
        this.gameTime = parsedGameTime;
    }

    private List<Car> initCars() {
        String input = inputView.inputCarName();
        String[] split = input.split(DELIMITER);
        return Arrays.stream(split)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void runGame() {
        for (int i = 0; i < gameTime; i++) {
            runSingleRound();
        }
    }

    private void runSingleRound() {
        cars.putRandomPowersToCar();

        cars.getCars().forEach(car -> outputView.printPosition(car.getName(), car.getPosition()));
        System.out.println();
    }

    public void finishGame() {
        Winners winners = new Winners(cars.calculateWinners());
        cars.getCars().forEach(car -> outputView.printPosition(car.getName(), car.getPosition()));
        outputView.printWinners(
                winners.getWinners().stream()
                .map(Winner::getName)
                .collect(Collectors.toUnmodifiableList()
                ));
    }


    private static void validateMaxGameTime(int gameTimeParsed) {
        if (gameTimeParsed >= MAX_GAME_TIME) {
            throw new IllegalArgumentException();
        }
    }

    private static int validateParsing(String gameTime) {
        try {
            int gameTimeParsed = Integer.parseInt(gameTime);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(gameTime);
    }
}
