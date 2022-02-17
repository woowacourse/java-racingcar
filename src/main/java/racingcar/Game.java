package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private static final String WINNER_NAME_DELIMITER = ", ";
    private static final String NEGATIVE_ERROR_MESSAGE = "[ERROR] 음수를 입력할 수 없습니다";
    private static final int ERROR_CRITERIA_VALUE_ZERO = 0;

    public void start() {
        Cars cars = new Cars(CarFactory.of(InputView.inputCarNames()));
        int count = validateGameCount(InputView.inputGameCount());
        OutputView.printGameResultTitle();
        for (int i = 0; i < count; i++) {
            play(cars);
            showResult(cars);
        }
        showWinner(Referee.judgeWinner(cars, cars.getMaxPosition()));
    }

    public void play(Cars cars) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        for (Car car : cars.getCars()) {
            car.move(numberGenerator);
        }
    }

    public void showResult(Cars cars) {
        for (Car car : cars.getCars()) {
            OutputView.printLineString(car.toString());
        }
        OutputView.printBlankLine();
    }

    public void showWinner(List<Car> winnerCars) {
        String winnerNames = winnerCars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_NAME_DELIMITER));

        OutputView.printWinner(winnerNames);
    }

    private int validateGameCount(int gameCount) {
        if (gameCount < ERROR_CRITERIA_VALUE_ZERO) {
            throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
        }
        return gameCount;
    }
}
