package racingcar.game;

import java.util.*;
import java.util.stream.Collectors;

import racingcar.domain.Car;

import static racingcar.util.ValidationUtil.*;
import static racingcar.util.RandomUtil.*;

public class RacingGame {

    private Set<Car> cars = new HashSet<>();
    private int totalAttempt;

    public void initCarNames(String carNames) {
        String[] names = carNames.split(",");
        isDuplicated(names);

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void initTotalAttempt(String attempt) {
        validateAttempt(attempt);
        totalAttempt = Integer.parseInt(attempt);
    }

    public String play() {
        StringBuilder totalExecutionResult = new StringBuilder();

        while (totalAttempt-- > 0) {
            run();
            totalExecutionResult.append(generateExecutionResult() + "\n");
        }

        return totalExecutionResult.toString();
    }

    public List<String> selectWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(c -> c.isSamePosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void run() {
        for (Car car : cars) {
            car.moveOrNot(generateRandomNumber());
        }
    }

    private String generateExecutionResult() {
        StringBuilder statement = new StringBuilder();

        for (Car car : cars) {
            statement.append(car.toString());
        }

        return statement.toString();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

}
