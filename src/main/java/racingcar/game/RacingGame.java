package racingcar.game;

import racingcar.entity.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.util.VerificationUtil.*;

public class RacingGame {

    private List<Car> cars = new ArrayList<>();
    private int totalAttemptCount;

    public String play(String carNames, String attempt) {
        initRacingCarGame(carNames, attempt);

        StringBuilder totalExecutionResult = new StringBuilder();
        while (totalAttemptCount-- > 0) {
            run();
            totalExecutionResult.append(generateExecutionResult() + "\n");
        }

        return totalExecutionResult.toString();
    }

    public List<String> selectWinners() {
        Collections.sort(cars);
        int maxPosition = cars.get(0).getPosition();

        return cars.stream()
                .filter(c -> c.getPosition() == maxPosition)
                .map(c -> c.getName())
                .collect(Collectors.toList());
    }

    private void initRacingCarGame(String carNames, String attempt) {
        initCarNames(carNames);
        initTotalAttempt(attempt);
    }

    private void initCarNames(String carNames) {
        String[] names = carNames.split(",");
        validateDuplication(names);

        for (String name : names) {
            validateCarName(name);
            cars.add(new Car(name));
        }
    }

    private void initTotalAttempt(String attempt) {
        validateAttempt(attempt);
        totalAttemptCount = Integer.parseInt(attempt);
    }

    private void run() {
        for (Car car : cars) {
            car.progress();
        }
    }

    private String generateExecutionResult() {
        StringBuilder statement = new StringBuilder();
        for (Car car : cars) {
            statement.append(car.toString());
        }
        return statement.toString();
    }

}
