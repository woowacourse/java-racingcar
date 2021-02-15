package domain;

import car.Car;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import view.OutputView;

public class RacingGame {

    private static final String DELIMITER = ",";
    private final List<Car> carNames;
    private final int round;
    private OutputView message = new OutputView();

    public RacingGame(List<Car> carNames, int round) {
        this.carNames = carNames;
        this.round = round;
    }

    public void moveCar(List<Car> carNames, int round) {

        message.roundStart();
        for (int i = 0; i < round; i++) {
            carNames.forEach(Car::moveOrStop);
            message.printResult(carNames);
        }

    }

    public void result() {
        String winner = findWinners(carNames);
        message.printWinner(winner);
    }

    private String findWinners(List<Car> cars) {
        final Map<Integer, List<String>> scoreBoard;

        scoreBoard = makeScoreBoard(cars);
        final int maxPosition = Collections.max(scoreBoard.keySet());
        return String.join(DELIMITER, scoreBoard.get(maxPosition));
    }

    private Map<Integer, List<String>> makeScoreBoard(List<Car> cars) {
        final Map<Integer, List<String>> scoreBoard = new HashMap<>();
        for (Car racingCar : cars) {
            final List<String> names =
                scoreBoard.computeIfAbsent(racingCar.getPosition(), ArrayList::new);
            names.add(racingCar.getName());
        }
        return scoreBoard;
    }
}
