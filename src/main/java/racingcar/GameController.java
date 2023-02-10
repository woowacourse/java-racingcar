package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winner;
import racingcar.domain.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private static final String DELIMITER = ",";
    private static final int MAX_GAME_TIME = 500;


    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    public static final int RANGE_BOUNDARY = 0;

    private final Cars cars;
    private final int gameTime;


    public GameController() {
        this.cars = new Cars(initCars());
        this.gameTime = initGameTime();
    }

    private static int initGameTime() {
        String gameTime = inputView.inputGameTime();
        int parsedGameTime = validateParsing(gameTime);
        validateMaxGameTime(parsedGameTime);
        validatePositive(parsedGameTime);
        return parsedGameTime;
    }

    private static void validatePositive(int parsedGameTime) {
        if (parsedGameTime <= RANGE_BOUNDARY) {
            throw new IllegalArgumentException("[ERROR] 양수만 입력 가능합니다.");
        }
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
            throw new IllegalArgumentException("[ERROR] 500회 미만으로 입력해주세요.");
        }
    }

    private static int validateParsing(String gameTime) {
        try {
            int gameTimeParsed = Integer.parseInt(gameTime);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
        return Integer.parseInt(gameTime);
    }
}
